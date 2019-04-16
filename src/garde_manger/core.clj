(ns garde-manger.core
  (:require [garde-manger.kafka :as kafka]
            [garde-manger.clinvar :as clinvar]
            [garde-manger.exchange :as dx]
            [clojure.tools.logging :as log]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  [["-w" "--write-file"]] ;; write output to standard location then exit
  )

(defn -main
  "I do everything."
  [& args]
  (let [opts (parse-opts args cli-options)]
    (if (-> opts :options :write-file)
      (dx/write-file-updates)
      (dx/exchange-update-loop))))
