(ns garde-manger.gene-dosage
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [clojure.set :refer [rename-keys]]
            [garde-manger.kafka :as kafka])
  (:import java.util.Properties
           [org.apache.kafka.clients.producer KafkaProducer Producer ProducerRecord]))

;; Topic to use for gene_dosage 
(def kafka-topic "gene_dosage")
(def dosage-root "https://search.clinicalgenome.org/kb/gene-dosage/")

;; JIRA maintains custom fields for the PMID links and descriptions that are used
;; as evidence to justify the interpretation
;; These are listed as pairs, the first is a PMID reference, the second is
;; a textual description
(def loss-evidence-fields
  [["customfield_10183" "customfield_10184"]
   ["customfield_10185" "customfield_10186"]
   ["customfield_10187" "customfield_10188"]])

(def gain-evidence-fields
  [["customfield_10189" "customfield_10190"]
   ["customfield_10191" "customfield_10192"]
   ["customfield_10193" "customfield_10194"]])


;; Mappings for custom fields; specific to loss or gain, gene or region
(def loss-fields {"customfield_10200" :phenotype
                  "customfield_10165" :interpretation
                  "customfield_10198" :description})

(def gain-fields {"customfield_10166" :interpretation
                  "customfield_10201" :phenotype})

(def gene-fields {"customfield_10157" :entrez_gene})

(def frontmatter-fields {"title" :title
                         "updated" :date
                         "status" :status})

;; Translation of raw scores into IRI-based types
;; note difference between interpretations for loss vs gain
(def loss-interp 
  {"3" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000092"
   "2" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000093"
   "1" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000095"
   "0" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000096"
   "30: Gene associated with autosomal recessive phenotype" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000094"})

(def gain-interp
  {"3" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000097"
   "2" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000098"
   "1" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000099"
   "0" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000100"})

(def loss-evidence "http://datamodel.clinicalgenome.org/clingen.owl#CG_000111")
(def gain-evidence "http://datamodel.clinicalgenome.org/clingen.owl#CG_000112")

;; Fields where we want to extract a more deeply nested value to represent
;; in the JSON, or otherwise apply some appropriate transformation
;; a map of functions to apply to the value of certain keys after retrieval
(def valued-keys [[:interpretation #(% "value")]
                  [:status #(% "name")]
                  [:phenotype #(if (empty? %)
                                 nil
                                 (str "http://purl.obolibrary.org/obo/OMIM_" %))]])

(defn send-message
  "Send an updated dosage curation into Kafka"
  [p k v]
  (.send p (ProducerRecord. kafka-topic k v)))

(defn extract-evidence-line
  [fields key-set type]
  (for [e key-set
        :let [pub (fields (first e))
              desc (fields (second e))]
        :when pub]
    {:publication pub, :description desc, :type type}))

(defn transform-gene-haploinsufficiency
  "Transform an assertion generated by JIRA into a standard format"
  [item]
  (let [id (item "key")
        fields (item "fields")
        evidence (extract-evidence-line fields loss-evidence-fields loss-evidence)
        key-set (merge frontmatter-fields gene-fields loss-fields)
        mapped-fields (-> fields (rename-keys key-set) (select-keys (vals key-set)))
        ;; apply transformations specified in valued-keys
        mapped-valued-fields (reduce #(update %1 (%2 0) (%2 1)) mapped-fields valued-keys)
        interpreted-fields (update mapped-valued-fields :interpretation loss-interp)]
    (merge {:id (str dosage-root id "H")}
           {:evidence_line  evidence}
           {:type "http://datamodel.clinicalgenome.org/clingen.owl#CG_000083"}
           interpreted-fields)))


;0,1,2,3, \"30: Gene associated with autosomal recessive phenotype\", \"40: Dosage sensitivity unlikely\"

(defn transform-jira-issues
  "Transform issues from JIRA into data model-ish format"
  []
  (let [query-str "project = ISCA AND type = \"ISCA Gene Curation\" AND \"ISCA Haploinsufficiency score\" in (3) ORDER BY updated DESC"
        url "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/search"
        result (http/get url {:query-params 
                              {:jql query-str
                               :startAt 0
                               :maxResults 5}
                              :content-type "application/json"
                              :basic-auth ["thnelson@geisinger.edu", "***REMOVED***"]})
        issues (-> result :body json/parse-string (get "issues"))
        messages (map transform-gene-haploinsufficiency issues)]
    ;; (with-open [p (kafka/producer)]
    ;;   (doseq [m messages]
    ;;     (.send p (ProducerRecord. "gene_dosage" (:id m) (json/generate-string m)))))
;    (with-open [w (clojure.java.io/writer "data/dosage_interps.json")])
    (doseq [m messages]
      (println (json/generate-string m {:pretty true})))))


