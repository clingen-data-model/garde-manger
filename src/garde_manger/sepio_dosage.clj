(ns garde-manger.sepio-dosage
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]
            [clojure.pprint :refer [pprint]]
            [clojure.string :as s]
            [flatland.ordered.map :refer [ordered-map]]
            [garde-manger.kafka :as kafka])
  (:import java.time.Instant
           java.time.OffsetDateTime))



(def frontmatter-fields {"title" :title
                         "updated" :modified
                         "status" :status})

(def context-uri "http://dataexchange.clinicalgenome.org/contexts/sepio-context-v1")

(def cg-prefix "https://search.clinicalgenome.org/entities/")
(def pmid-prefix "https://www.ncbi.nlm.nih.gov/pubmed/")

(defn -format-jira-datetime-string
  "Corrects flaw in JIRA's formatting of datetime strings. By default JIRA does not
  include a colon in the offset, which is incompatible with standard java.util.time
  libraries. This inserts an appropriate offset with a regex"
  [s]
  (s/replace s #"(\d\d)(\d\d)$" "$1:$2"))

;; TODO Java chokes on parsing a time offset without a colon, and is unwilling
;; to construct a ISO_INSTANT from the format parsed below. Need to either hack
;; a colon in the datetime or understand better how Java is doing things
(defn time-str-offset-to-instant [s]
  ;; "2018-03-27T09:55:41.000-0400"
  (->> s
       -format-jira-datetime-string
       OffsetDateTime/parse
       Instant/from
       str))

(defn construct-study-finding
  [interp [pmid-field description-field]]
  (when-let [pmid (get-in interp [:fields pmid-field])]
    {:type "SEPIO:0000173"
     :source (str "PMID:" pmid)
     :description (get-in interp [:fields description-field])}))

;; Key is the dosage of the area (1: haploinsufficient, 3: triplosensitive)
;; Each evidence field is a tuple with the PMID first and the described evidence
;; second
(def evidence-field-map
  {1 [[:customfield-10183 :customfield-10184]
      [:customfield-10185 :customfield-10186]
      [:customfield-10187 :customfield-10188]]
   3 [[:customfield-10189 :customfield-10190]
      [:customfield-10191 :customfield-10192]
      [:customfield-10193 :customfield-10194]]})

(defn construct-study-findings
  [interp dosage]
  (remove nil? (map #(construct-study-finding interp %) (evidence-field-map dosage))))

(defn interpreted-dosage 
  "dosage of variant is 0 when evidence supports AR phenotype"
  [interp dosage]
  (if (and (= 1 dosage) (= "30" (get-in interp [:fields :customfield-10165 :value])))
    0
    dosage))

(defn construct-gene-dosage-variant
  "Construct the variant representing the stated dosage of a gene"
  [interp dosage]
  (let [fields (:fields interp)]
    {:has-feature (:customfield-10157 fields)
     :type "CG:0009" ;; Gene dosage in GENO
     :feature-count (interpreted-dosage interp dosage)}))

(defn -get-dosage-dependent-fields [interp dosage fields]
  (reduce #(if-let [v (get-in interp (cons :fields (first %2)))] 
             (assoc %1 (second %2) v)
             %1) {} (get fields dosage)))

(def proposition-fields 
  {1 [[[:customfield-10200] :has-object]]
   3 [[[:customfield-10201] :has-object]]})

(defn -substitute-genetic-condition
  [result]
  (if-let [omim-id (:has-object result)]
    (assoc result :has-object (str "OMIM:" (s/trim omim-id)))
    result))

(defn construct-proposition
  "Return proposition object from interpretation"
  [interp dosage]
  (let [result {:id (str cg-prefix (:key interp) "x" dosage)
                 :has-subject (construct-gene-dosage-variant interp dosage)
                 :has-predicate "http://purl.obolibrary.org/obo/GENO_0000840"
                 :type "CG:0006"}]
    (-> result 
        (merge (-get-dosage-dependent-fields interp dosage proposition-fields))
        -substitute-genetic-condition)))

(defn construct-contribution
  [interp]
  {:activity-date (time-str-offset-to-instant (get-in interp [:fields :resolutiondate]))
   :realizes "SEPIO:0000331"})

(defn -get-evidence [interp dosage]
  (seq (construct-study-findings interp dosage)))

(defn -add-evidence [result interp dosage]
  (if-let [e (-get-evidence interp dosage)]
    (assoc result :has-evidence-with-item e)
    result))

(def evidence-levels {"3" "CG:00000"
                      "2" "CG:00001"
                      "1" "CG:00002"
                      "0" "CG:00003"
                      "40: Dosage sensitivity unlikely" "CG:00004"})

(defn -convert-assertion-descriptor [assertion]
  (if-let [descriptor (evidence-levels (:has-object assertion))]
    (assoc assertion :has-object descriptor)
    (dissoc assertion :has-object)))

;; ;; as above, 1: loss, 3: gain
(def dosage-assertion-fields
  {1 [[[:customfield-10165 :value] :has-object]
      [[:customfield-10198] :description]]
   3 [[[:customfield-10166 :value] :has-object]
      [[:customfield-10199] :description]]})

(defn construct-assertion
  [interp dosage]
  (pprint interp)
  (let [date-part (re-find #"^[^\.]*" (get-in interp [:fields :resolutiondate]))
        dosage-dependent-fields (-get-dosage-dependent-fields interp
                                                              dosage
                                                              dosage-assertion-fields)
        result {:id (str cg-prefix (:key interp) "x" dosage "-" date-part)
                :qualified-contribution (construct-contribution interp)
                :has-subject (construct-proposition interp dosage)
                :has-predicate "SEPIO:0000146"
                :type "CG:0007"}]
    (-> result
        (-add-evidence interp dosage)
        (merge dosage-dependent-fields)
        -convert-assertion-descriptor)))

(defn convert-gene-interp
  "Convert gene interpretation to SEPIO format"
  [interp]
  [(construct-assertion interp 1)
   (construct-assertion interp 3)])

(defn -interp-json-ld [interp]
  (let [m (into (ordered-map) {"@context" context-uri})
        interp-ld (into m interp)
        json-str (json/generate-string interp-ld
                                       {:pretty true
                                        :key-fn ->snake_case_string})]
    [(:id interp) json-str]))

(defn interps-json-ld [interps]
  (map -interp-json-ld interps))

(defn -short-id [from-str]
  (s/replace-first from-str cg-prefix ""))

(defn sepio-interps [jira-data]
  (let [interps (mapcat convert-gene-interp jira-data)]
    (interps-json-ld interps)))

(defn convert-local-interps
  "convert interpretations stored locally on filesystem to output dir"
  []
  (let [files (.listFiles (io/file "data/jira-output/"))
        jira-data (map #(json/parse-stream (io/reader %) ->kebab-case-keyword)
                       files)
        interps (mapcat convert-gene-interp jira-data)
        json-ld-interps (interps-json-ld interps)]
    (doseq [i json-ld-interps]
      (spit (str "data/json-ld-output/" (-short-id (first i)) ".jsonld")
            (second i)))))


