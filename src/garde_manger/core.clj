(ns garde-manger.core
  (:require [garde-manger.kafka :as kafka]
            [garde-manger.clinvar :as clinvar]
            [garde-manger.gene-dosage :as gene-dosage]
            [clojure.tools.logging :as log]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  [["-w" "--write-file"]] ;; write output to standard location then exit
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [opts (parse-opts args cli-options)]
    (if (-> opts :options :write-file)
      (gene-dosage/write-file-updates)
      (gene-dosage/exchange-update-loop))))
