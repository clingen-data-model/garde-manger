(ns garde-manger.exchange
  (:require [garde-manger.gene-dosage :as dosage]
            [garde-manger.sepio-dosage :as sepio]
            [garde-manger.jira :as jira]
            [garde-manger.kafka :as kafka]
            [clojure.pprint :refer [pprint]]
            [cheshire.core :as json]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [clojure.walk :as walk :refer [postwalk]]
            [camel-snake-kebab.core :refer [->kebab-case-keyword]])
  (:import java.time.LocalDateTime
           java.time.format.DateTimeFormatter
           [org.apache.kafka.clients.producer ProducerRecord]))

(def file-target "../serveur/data/import/")
(def start-date "2011-01-01")
(def last-polled-file "state/last-polled")
(def date-time-format (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm"))


(defn kebab-keys
  "Recursively transforms all map keys into kebab-cased keywords."
  [m]
  (let [f (fn [[k v]] (if (string? k) [(->kebab-case-keyword k) v] [k v]))]
    ;; only apply to maps
    (postwalk (fn [x] (if (map? x) (into {} (map f x)) x)) m)))

(defn push-message
  "Push incoming messages to Kafka-based data exchange"
  [message producer kafka-topic]
  (let [msg-str (if (string? message) message (json/generate-string message))]
    (.send producer (ProducerRecord. kafka-topic (:id message) msg-str))))

(defn write-message
  "Write incoming messages to file"
  [message]
  (let [key (re-find #"ISCA.*$" (:id message))
        path (str file-target key)]
    (io/make-parents path)
    (with-open [w (io/writer path)]
      (json/generate-stream message w {:pretty true}))))

(defn write-file-update-for-type
  [datetime curation-type] 
  (doseq [batch (jira/issues (jira/type-description curation-type) datetime)
          message (if (= :gene curation-type) (dosage/transform-gene-issues batch)
                      (dosage/transform-region-issues batch))]
    (write-message message)))

(defn write-file-updates
  "Write all update files since beginning of time (or whenever dosage started...)"
  []
  (write-file-update-for-type start-date :gene)
  (write-file-update-for-type start-date :region))

(defn send-update-to-exchange
  "Update data exchange with issues modified after given time"
  [datetime producer] 
  (doseq [batch (jira/issues "ISCA Gene Curation" datetime)]
    (doseq [message (dosage/transform-gene-issues batch)]
      (push-message message producer "gene_dosage"))
    (println "Transforming gene batch.")
    (doseq [message (sepio/sepio-interps (map kebab-keys batch))]
      (push-message message producer "gene_dosage_beta")))
  (doseq [batch (jira/issues "ISCA Region Curation" datetime)]
    (println "Transforming region batch.")
    (doseq [message (sepio/sepio-interps (map kebab-keys batch))]
      (push-message message producer "gene_dosage_beta"))))

(defn exchange-update-loop
  "Loop to update data exchange with messages updated after current date and time"
  []
  (while true
    (try
      (with-open [producer (kafka/producer)]
        (let [last-polled (if (.exists (io/as-file last-polled-file))
                            (slurp last-polled-file)
                            start-date)
              ;; TODO make sure this is in alignment with timezones used in JIRA
              ;; ideally automatically
              current-time (-> (LocalDateTime/now) (.format date-time-format))]
          ;; Update last polled
          (println "Querying JIRA from " last-polled)
          (log/info "Querying JIRA from " last-polled)
          ;; TODO Consider using current time as end-time for search to avoid
          ;; double-pushing entities updated between polling and now
          (send-update-to-exchange last-polled producer)
          (spit last-polled-file current-time)))
      (catch Exception e (log/error e)))
    (Thread/sleep (* 1000 60 5))))
