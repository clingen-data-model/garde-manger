(ns garde-manger.sepio-dosage
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]
            [clojure.pprint :refer [pprint]]
            [clojure.string :as s]
            [flatland.ordered.map :refer [ordered-map]]
            [garde-manger.kafka :as kafka]
            [camel-snake-kebab.core :refer :all])
  (:import java.time.Instant
           java.time.OffsetDateTime))

(def context (into (ordered-map) [["id" "@id"]
                                  ["type" "@type"]
                                  ["SEPIO" "http://purl.obolibrary.org/obo/SEPIO_"]
                                  ["PMID" "https://www.ncbi.nlm.nih.gov/pubmed/"]
                                  ["BFO" "http://purl.obolibrary.org/obo/BFO_"]
                                  ["CG" "http://dataexchange.clinicalgenome.org/terms/"]
                                  ["DC" "http://purl.org/dc/elements/1.1/"]
                                  ["OMIM" "http://identifiers.org/omim/"]
                                  ["MONDO" "http://purl.obolibrary.org/obo/MONDO_"]
                                  ["FALDO" "http://biohackathon.org/resource/faldo#"]
                                  ["NCBI_NU" "https://www.ncbi.nlm.nih.gov/nuccore/"]
                                  ["RDFS" "http://www.w3.org/2000/01/rdf-schema#"]
                                  ["GENO" "http://purl.obolibrary.org/obo/GENO_"]
                                  ["has_evidence_with_item" {"@id" "SEPIO:0000189"
                                                             "@type" "@id"}]
                                  ["has_predicate" {"@id" "SEPIO:0000389"
                                                    "@type" "@id"}]
                                  ["has_subject" {"@id" "SEPIO:0000388"
                                                  "@type" "@id"}]
                                  ["has_object" {"@id" "SEPIO:0000390"
                                                 "@type" "@id"}]
                                  ["qualified_contribution" {"@id" "SEPIO:0000159" 
                                                             "@type" "@id"}]
                                  ["reference" {"@id" "FALDO:reference"
                                                "@type" "@id"}]
                                  ["realizes" {"@id" "BFO:0000055"
                                               "@type" "@id"}]
                                  ["source" {"@id" "IAO:0000115"
                                               "@type" "@id"}]
                                  ["is_feature_affected_by" {"@id" "GENO:0000445"
                                                             "@type" "@id"}]
                                  ["label" "RDFS:label"]
                                  ["activity_date" "SEPIO:0000160"]
                                  ["has_count" "GENO:0000917"]
                                  ["start_position" "GENO:0000894"]
                                  ["end_position" "GENO:0000895"]
                                  ["description" "DC:description"]]))

(def frontmatter-fields {"title" :title
                         "updated" :modified
                         "status" :status})

(def context-uri "http://dataexchange.clinicalgenome.org/contexts/sepio-context-v1")
(def cg-prefix "https://search.clinicalgenome.org/entities/")

(def chr-to-ref {"chr1" "NCBI_NU:NC_000001.10"
                 "chr2" "NCBI_NU:NC_000002.11"
                 "chr3" "NCBI_NU:NC_000003.11"
                 "chr4" "NCBI_NU:NC_000004.11"
                 "chr5" "NCBI_NU:NC_000005.9"
                 "chr6" "NCBI_NU:NC_000006.11"
                 "chr7" "NCBI_NU:NC_000007.13"
                 "chr8" "NCBI_NU:NC_000008.10"
                 "chr9" "NCBI_NU:NC_000009.11"
                 "chr10" "NCBI_NU:NC_000010.10"
                 "chr11" "NCBI_NU:NC_000011.9"
                 "chr12" "NCBI_NU:NC_000012.11"
                 "chr13" "NCBI_NU:NC_000013.10"
                 "chr14" "NCBI_NU:NC_000014.8"
                 "chr15" "NCBI_NU:NC_000015.9"
                 "chr16" "NCBI_NU:NC_000016.9"
                 "chr17" "NCBI_NU:NC_000017.10"
                 "chr18" "NCBI_NU:NC_000018.9"
                 "chr19" "NCBI_NU:NC_000019.9"
                 "chr20" "NCBI_NU:NC_000020.10"
                 "chr21" "NCBI_NU:NC_000021.8"
                 "chr22" "NCBI_NU:NC_000022.10"
                 "chrX" "NCBI_NU:NC_000023.10"
                 "chrY" "NCBI_NU:NC_000024.9"})

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
     :source (str "PMID:" (re-find #"\d+" pmid))
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

(defn construct-location [interp]
  (when-let [loc-str (get-in interp [:fields :customfield-10160])]
    (let [[_ chr start-coord end-coord] (re-find #"(\w+):(\d+)-(\d+)" loc-str)]
      {:type "GENO:0000902"
       :label (get-in interp [:fields :customfield-10202])
       :reference (chr-to-ref chr)
       :start-position start-coord
       :end-position end-coord})))

(defn dosage-subject [interp]
  (if-let [gene (get-in interp [:fields :customfield-10157])]
    gene
    (construct-location interp)))

(defn construct-gene-dosage-variant
  "Construct the variant representing the stated dosage of a gene"
  [interp dosage]
  (let [fields (:fields interp)]
    {:is-feature-affected-by (dosage-subject interp)
     :type "GENO:0000923" 
     :has-count (interpreted-dosage interp dosage)}))

(def evidence-levels {"3" "SEPIO:0002006"
                      "2" "SEPIO:0002009"
                      "1" "SEPIO:0002007"
                      "0" "SEPIO:0002008"
                      ;; assume moderate evidence for dosage sensitivity unlikely
                      "40: Dosage sensitivity unlikely" "SEPIO:0002009"})

(defn- get-dosage-dependent-fields [interp dosage fields]
  (reduce #(let [ks (cons :fields (first %2))]
               (if-let [v (get-in interp ks)] 
                 (assoc %1 (second %2) v)
                 %1)) {} (get fields dosage)))

(def proposition-fields 
  {1 [[[:customfield-10200] :has-object]]
   3 [[[:customfield-10201] :has-object]]})

(defn- format-comma-separated-list [prefix list-string]
  (if (s/includes? list-string ",")
    (mapv #(str prefix (re-find #"\d+"%)) (-> list-string (s/split #",")))
    (str prefix (re-find #"\d+" list-string))))

(defn- substitute-genetic-condition
  [result]
  (if-let [omim-id (:has-object result)]
    (assoc result :has-object (format-comma-separated-list "OMIM:" omim-id))
    (assoc result :has-object (str "MONDO:0000001"))))

;; ;; as above, 1: loss, 3: gain
(def dosage-assertion-fields
  {1 [[[:customfield-10165 :value] :has-object]
      [[:customfield-10198] :description]]
   3 [[[:customfield-10166 :value] :has-object]
      [[:customfield-10199] :description]]})

(defn- proposition-predicate [interp dosage]
  (let [fields (get-dosage-dependent-fields interp dosage dosage-assertion-fields)]
    (if (= "40: Dosage sensitivity unlikely" (:has-object fields))
      "GENO:0000843"
      "GENO:0000840")))

(defn construct-proposition
  "Return proposition object from interpretation"
  [interp dosage]
  (let [result {:id (str cg-prefix (:key interp) "x" dosage)
                 :has-subject (construct-gene-dosage-variant interp dosage)
                 :has-predicate (proposition-predicate interp dosage)
                 :type "SEPIO:0002003"}]
    (-> result 
        (merge (get-dosage-dependent-fields interp dosage proposition-fields))       
        substitute-genetic-condition)))

(defn resolution-date [interp]
  (time-str-offset-to-instant (get-in interp [:fields :resolutiondate])))

(defn construct-contribution
  [interp]
  {:activity-date (resolution-date interp)
   :realizes "SEPIO:0000331"})

(defn- get-evidence [interp dosage]
  (seq (construct-study-findings interp dosage)))

(defn -add-evidence [result interp dosage]
  (if-let [e (get-evidence interp dosage)]
    (assoc result :has-evidence-with-item e)
    result))

(defn- get-dosage-assertion-fields [interp dosage]
  (let [fields (get-dosage-dependent-fields interp
                                             dosage
                                             dosage-assertion-fields)]
    (if-let [descriptor (evidence-levels (:has-object fields))]
      (assoc fields :has-object (s/trim descriptor))
      (dissoc fields :has-object))))

(defn construct-assertion
  [interp dosage]
  (let [;;date-part (re-find #"^[^\.]*" (get-in interp [:fields :resolutiondate]))
        date-part (resolution-date interp)
        result {:id (str cg-prefix (:key interp) "x" dosage "-" date-part)
                :qualified-contribution (construct-contribution interp)
                :has-subject (construct-proposition interp dosage)
                :has-predicate "SEPIO:0000146"
                :type "SEPIO:0002001"}
        dosage-fields (get-dosage-assertion-fields interp dosage)]
    (-> result
        (-add-evidence interp dosage)
        (merge dosage-fields))))

(defn convert-gene-interp
  "Convert gene interpretation to SEPIO format"
  [interp]
  [(construct-assertion interp 1)
   (construct-assertion interp 3)])

(defn- interp-json-ld [interp]
  (let [m (into (ordered-map) {"@context" context})
        interp-ld (into m interp)
        json-str (json/generate-string interp-ld
                                       {:pretty true
                                        :key-fn ->snake_case_string})]
    [(:id interp) json-str]))

(defn- interpretation-to-sepio [origin-data]
  (let [parsed-data (if (instance? java.io.Reader origin-data)
                      (json/parse-stream origin-data ->kebab-case-keyword)
                      (json/parse-string origin-data ->kebab-case-keyword))]
    (->> parsed-data convert-gene-interp (map interp-json-ld))))

(defn -short-id [from-str]
  (s/replace-first from-str cg-prefix ""))

(defn sepio-interps [jira-data]
  (mapcat interpretation-to-sepio jira-data))

(defn convert-local-interps
  "convert interpretations stored locally on filesystem to output dir"
  [source destination]
  (let [files (.listFiles (io/file source))
        json-ld-interps (mapcat #(interpretation-to-sepio (io/reader %)) files)]
    (doseq [i json-ld-interps]
      (spit (str destination (-short-id (first i)) ".jsonld")
            (second i)))))

