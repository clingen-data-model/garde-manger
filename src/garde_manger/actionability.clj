(ns garde-manger.actionability
  (:require [cheshire.core :as json]
            [clojure.java.io :as io]
            [clojure.pprint :as pp :refer [pprint]]))

(def act-path "data/actionability.json")

(def template {"jsonMessageVersion"  "AV1",
               "statusPublishFlag"  "Publish",
               "type"  "actionability",
               "affiliation" {"id"  "AWG",
                              "name"  "Actionability Working Group"},
               "iri"  "https://actionability.clinicalgenome.org/REST/v1/grp/actionability/kb/actionability_release/coll/combined_model/doc/",
               "curationVersion"  "1.2.0",
               "statusFlag"  "Released - Under Revision",
               "scoreDetails"  "https://actionability.clinicalgenome.org/redmine/projects/actionability_release/genboree_ac/ui/stg2SummaryRpt?doc="})

(defn gene-list
  [record]
  (let [genes (map #(get-in % ["Gene" "properties" "HGNCId" "value"])
                   (get-in record ["properties" "Genes" "items"]))]
    (map (fn [g] {"curie" g}) genes)))

(defn disease-list
  [record]
  (let [diseases (map #(get-in % ["OmimID" "value"])
                      (get-in record ["properties" "Syndrome" "properties" "OmimIDs" "items"]))]
    (map (fn [d] {"iri" (str "http://purl.obolibrary.org/obo/OMIM_" d)}) diseases)))

(defn intervention-list
  [outcome]
  (let [interventions (map #(get % "Intervention")
                           (get-in outcome ["properties" "Interventions" "items"]))]
    (map (fn [i] {"Intervention" (get i "value")
                  "Effectiveness" (get-in i ["properties" "Effectiveness" "value"])
                  "Nature of Intervention" (get-in i ["properties" "Nature Of Intervention" "value"])
                  "Total" (get-in i ["properties" "Overall Score" "value"])})
         interventions)))

(defn outcome-list
  [record]
  (let [outcomes (map #(get % "Outcome")
                      (get-in record ["properties" "Score" "properties" "Final Scores"
                                      "properties" "Outcomes" "items"]))]
    (map (fn [o] {"Outcome" (get o "value")
                  "Severity" (get-in o ["properties" "Severity" "value"])
                  "Likelihood" (get-in o ["properties" "Likelihood" "value"])
                  "Interventions" (intervention-list o)})
         outcomes)))

(defn transform-record 
  [record]
  (let [id (get record "value")]
    {"jsonMessageVersion"  "AV1",
     "statusPublishFlag"  "Publish",
     "type"  "actionability",
     "dateISO8601" (get-in record ["properties" "Release" "properties" "Date" "value"])
     "affiliation" {"id"  "AWG",
                    "name"  "Actionability Working Group"},
     "iri"   (str "https://actionability.clinicalgenome.org/REST/v1/grp/actionability/kb/actionability_release/coll/combined_model/doc/" id),
     "curationVersion"  "1.2.0",
     "statusFlag"  "Released",
     "scoreDetails" (str "https://actionability.clinicalgenome.org/redmine/projects/actionability_release/genboree_ac/ui/stg2SummaryRpt?doc=" id)
     "genes" (gene-list record)
     "conditions" (disease-list record)
     "scores" (outcome-list record)}))

(defn parse-actionability
  "Parse stream of actionability records"
  [s]
  (let [act-json (json/parse-stream s)]
       (filter #(= "Released" (get-in % ["properties" "Status" "value"]))
               (map #(get % "ActionabilityDocID") (-> act-json first second)))))

(defn write-actionability
  "Import actionability records from actionability API (not data exchange message"
  []
  (let [records (parse-actionability (io/reader act-path))]
    (doseq [r records]
      (let [id (get r "value")]
        ;;(pprint (get-in r ["properties" "Release" "properties" "Date" "value"]))
        (with-open [w (io/writer (str "output/" id ".json"))]
          (json/generate-stream (transform-record r) w {:pretty true}))))))


