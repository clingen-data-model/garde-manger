(ns garde-manger.gene-dosage
  (:require [clojure.set :refer [rename-keys]]
            [clojure.pprint :as pprint :refer [pprint]]))

(def dosage-root "https://search.clinicalgenome.org/kb/gene-dosage/")
(def region-root "https://search.clinicalgenome.org/kb/regions/")

;; JIRA maintains custom fields for the PMID links and descriptions that are used
;; as evidence to justify the interpretation
;; These are listed as pairs, the first is a PMID reference, the second is
;; a textual description

(def assertion-type-map
  {:gene "http://datamodel.clinicalgenome.org/terms/CG_000083"
   :region "http://datamodel.clinicalgenome.org/terms/CG_000116"})

(def evidence-field-map
  {:loss [["customfield_10183" "customfield_10184" "-EL-H1"]
          ["customfield_10185" "customfield_10186" "-EL-H2"]
          ["customfield_10187" "customfield_10188" "-EL-H3"]]
   :gain [["customfield_10189" "customfield_10190" "-EL-T1"]
          ["customfield_10191" "customfield_10192" "-EL-T2"]
          ["customfield_10193" "customfield_10194" "-EL-T3"]]})

(def assertion-suffix
  {:loss "-H"
   :gain "-T"})

;; Mappings for custom fields; specific to loss or gain, gene or region
(def assertion-fields
  {:loss {"customfield_10200" :phenotype
          "customfield_10165" :interpretation
          "customfield_10198" :description}
   :gain {"customfield_10166" :interpretation
          "customfield_10201" :phenotype
          "customfield_10199" :description}})

(def gene-fields {"customfield_10157" :gene})

(def frontmatter-fields {"title" :title
                         "updated" :modified
                         "status" :status})

(def interp-codes
  {:loss {"3" "http://datamodel.clinicalgenome.org/terms/CG_000092"
          "2" "http://datamodel.clinicalgenome.org/terms/CG_000093"
          "1" "http://datamodel.clinicalgenome.org/terms/CG_000095"
          "0" "http://datamodel.clinicalgenome.org/terms/CG_000096"
          "30: Gene associated with autosomal recessive phenotype" "http://datamodel.clinicalgenome.org/terms/CG_000094"
          "40: Dosage sensitivity unlikely" "http://datamodel.clinicalgenome.org/terms/CG_000120"}
   :gain {"3" "http://datamodel.clinicalgenome.org/terms/CG_000097"
          "2" "http://datamodel.clinicalgenome.org/terms/CG_000098"
          "1" "http://datamodel.clinicalgenome.org/terms/CG_000099"
          "0" "http://datamodel.clinicalgenome.org/terms/CG_000100"
          "40: Dosage sensitivity unlikely" "http://datamodel.clinicalgenome.org/terms/CG_000121"}})

(def status-codes
  {"Closed" "http://datamodel.clinicalgenome.org/terms/CG_000114"
   "Under Group Review" "http://datamodel.clinicalgenome.org/terms/CG_000117"
   "Open" "http://datamodel.clinicalgenome.org/terms/CG_000119"
   "Reopened" "http://datamodel.clinicalgenome.org/terms/CG_000118"
   "Under Primary Review" "http://datamodel.clinicalgenome.org/terms/CG_000115"
   "Under Secondary Review" "http://datamodel.clinicalgenome.org/terms/CG_000116"})

(def evidence-type {:loss "http://datamodel.clinicalgenome.org/terms/CG_000111"
                    :gain "http://datamodel.clinicalgenome.org/terms/CG_000112"})

;; Fields where we want to extract a more deeply nested value to represent
;; in the JSON, or otherwise apply some appropriate transformation
;; a map of functions to apply to the value of certain keys after retrieval
(def valued-keys [[:interpretation #(get % "value")]
                  [:status #(get % "name")]
                  [:phenotype #(if (empty? %)
                                 nil
                                 (str "http://purl.obolibrary.org/obo/OMIM_" %))]])

(defn extract-evidence-line
  "Given keyset, identifying the evidence and description fields for the assertion,
  extract the evidence line and the description"
  [fields key-set type id]
  (for [e key-set
        :let [pub (fields (first e))
              desc (fields (second e))
              suffix (e 2)]
        :when pub]
    {:id (str id suffix)
     :information (str "https://www.ncbi.nlm.nih.gov/pubmed/" pub)
     :description desc
     :type type}))

(defn extract-region-context
  "From the issue, extract the region context"
  [issue]
  (let [coords (get-in issue ["fields" "customfield_10160"])
        [_ chr start stop] (re-matches #"chr([XY0-9]*):([0-9]*)-([0-9]*)" coords)
        region-iri (str region-root (issue "key") "-R")]
    {:id (str region-root (issue "key") "-CX")
     :start start
     :stop stop
     :chromosome chr
     :assembly "GRCh37"
     :type "http://datamodel.clinicalgenome.org/terms/CG_000117"}))

(defn extract-region
  "From the issue, extract the region description (name and root iri)"
  [issue]
  (let [fields (issue "fields")]
    {:label (fields "customfield_10202")
     :id (str region-root (issue "key") "-R")
     :type "http://purl.obolibrary.org/obo/SO_0000001"
     :context (extract-region-context issue)}))

(defn extract-assertion
  "Extract the assertion entity from an issue given the appropriate type (:loss or :gain)"
  [item assertion-type region-type]
  (let [id (str dosage-root (item "key") (assertion-type assertion-suffix))
        fields (item "fields")
        evidence (extract-evidence-line fields (evidence-field-map assertion-type)
                                        (evidence-type assertion-type) id)
        key-set (merge frontmatter-fields (assertion-fields assertion-type)
                       (if (= :gene region-type) gene-fields {}))
        mapped-fields (-> fields (rename-keys key-set) (select-keys (vals key-set)))
        ;; apply transformations specified in valued-keys
        mapped-valued-fields (do (pprint id) (reduce #(update %1 (%2 0) (%2 1)) mapped-fields valued-keys))
        interpreted-fields (->  mapped-valued-fields 
                                (update :interpretation (interp-codes assertion-type))
                                (update :status status-codes))
        region (if (= :region region-type)
                 {:region (extract-region item)}
                 {})]
    (merge {:id id}
           {:evidence  evidence}
           {:type (assertion-type-map region-type)}
           interpreted-fields
           region)))

(defn transform-region-issues
  "Transform issues from JIRA into data model format"
  [issues]
  (into (map #(extract-assertion % :loss :region) issues)
        (map #(extract-assertion % :gain :region) issues)))

(defn transform-gene-issues
  "Transform issues from JIRA into data model-ish format"
  [issues]
  (into (map #(extract-assertion % :loss :gene) issues)
        (map #(extract-assertion % :gain :gene) issues)))





