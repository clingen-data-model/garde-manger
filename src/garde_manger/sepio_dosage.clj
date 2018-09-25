(ns garde-manger.sepio-dosage
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]
            [clojure.pprint :refer [pprint]]
            [camel-snake-kebab.core :refer :all]))

(defn construct-gene-dosage-variant
  "Construct the variant representing the stated dosage of a gene"
  [interp dosage]
  (let [id (str (java.util.UUID/randomUUID))
        fields (:fields interp)]
    {:id id
     :sequence (:customfield-10157 fields)
     :count dosage}))


(defn construct-proposition
  "Return proposition object from interpretation"
  [interp variant & condition]
  {:has-subject nil
   :has-object (if condition condition "http://purl.obolibrary.org/obo/MONDO_0000001")
   :has-predicate "http://purl.obolibrary.org/obo/GENO_0000840"
   :type "SEPIO:0000000"})

(defn convert-gene-interp
  "Convert gene interpretation to SEPIO format"
  [interp]
  (let [loss-v (construct-gene-dosage-variant interp 1)
        gain-v (construct-gene-dosage-variant interp 3)]
    [[loss-v
      (construct-proposition interp (:id loss-v))]
     [gain-v
      (construct-proposition interp (:id gain-v))]]))

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
