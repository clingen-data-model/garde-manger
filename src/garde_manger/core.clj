(ns garde-manger.core
  (:require [garde-manger.kafka :as kafka]
            [garde-manger.clinvar :as clinvar]
            [garde-manger.gene-dosage :as gene-dosage])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "pushing gene dosage to kafka")
  (gene-dosage/send-update-to-exchange gene-dosage/start-date))
