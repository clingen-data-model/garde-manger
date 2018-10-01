(ns garde-manger.sepio-dosage
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]
            [clojure.pprint :refer [pprint]]
            [camel-snake-kebab.core :refer :all]))

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

;; as above, 1: loss, 3: gain
(def assertion-fields
  {1 {:customfield-10200 :phenotype
      :customfield-10165 :interpretation
      :customfield-10198 :description}
   3 {:customfield-10166 :interpretation
      :customfield-10201 :phenotype
      :customfield-10199 :description}})

(def frontmatter-fields {"title" :title
                         "updated" :modified
                         "status" :status})

(def cg-prefix "https://search.clinicalgenome.org/entities/")
(def pmid-prefix "https://www.ncbi.nlm.nih.gov/pubmed/")

(defn construct-study-finding
  [interp [pmid-field description-field]]
  (when-let [pmid (get-in interp [:fields pmid-field])]
    {:type "SEPIO:0000173"
     :source (str "PMID:" pmid)
     :description (get-in interp [:fields description-field])}))

(defn construct-study-findings
  [interp dosage]
  (remove nil? (map #(construct-study-finding interp %) (evidence-field-map dosage))))

(defn construct-gene-dosage-variant
  "Construct the variant representing the stated dosage of a gene"
  [interp dosage]
  (let [fields (:fields interp)]
    {:sequence (:customfield-10157 fields)
     :count dosage}))


(defn construct-proposition
  "Return proposition object from interpretation"
  [interp dosage]
  {:id (str cg-prefix (:key interp) "x" dosage)
   :has-subject (construct-gene-dosage-variant interp dosage)
   :has-object "http://purl.obolibrary.org/obo/MONDO_0000001"
   :has-predicate "http://purl.obolibrary.org/obo/GENO_0000840"
   :type "SEPIO:0000000"})

(defn construct-contribution
  [interp]
  {:activity-date (get-in interp [:fields :resolutiondate])
   :realizes "SEPIO:0000331"})

(defn construct-assertion
  [interp dosage]
  (let [date-part (re-find #"^[^\.]*" (get-in interp [:fields :resolutiondate]))
        result {:id (str cg-prefix (:key interp) "x" dosage "-" date-part)
                :qualified-contribution (construct-contribution interp)
                :subject (construct-proposition interp dosage)
                :predicate "SEPIO:0000146"
                :type "SEPIO:000001"}]
    (if-let [evidence (seq (construct-study-findings interp dosage))]
      (assoc result :has-evidence-with-item evidence)
      result)))

(defn convert-gene-interp
  "Convert gene interpretation to SEPIO format"
  [interp]
  [(construct-assertion interp 1)
   (construct-assertion interp 3)])

(defn convert-local-interps
  "convert interpretations stored locally on filesystem--primarily for testing"
  []
  (let [files (take 1 (.listFiles (io/file "data/jira-output/")))
        jira-data (map #(json/parse-stream (io/reader %) ->kebab-case-keyword)
                       files)
        interps (mapcat convert-gene-interp jira-data)]
    ;; (pprint (map #(.getName %) files))
    ;;(pprint jira-data)
    (pprint interps)
    ))
