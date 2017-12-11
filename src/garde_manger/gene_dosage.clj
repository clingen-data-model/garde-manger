(ns garde-manger.gene-dosage
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [clojure.set :refer [rename-keys]]
            [garde-manger.kafka :as kafka]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [clojure.pprint :as pprint :refer [pprint]])
  (:import java.util.Properties
           java.time.LocalDateTime
           java.time.format.DateTimeFormatter
           [org.apache.kafka.clients.producer KafkaProducer Producer ProducerRecord]))

;; Topic to use for gene_dosage 
(def kafka-topic "gene_dosage")
(def dosage-root "https://search.clinicalgenome.org/kb/gene-dosage/")
(def region-root "https://search.clinicalgenome.org/kb/regions/")
(def start-date "2011-01-01")
(def batch-size 50)
(def last-polled-file "state/last-polled")
(def date-time-format (DateTimeFormatter/ofPattern "yyyy-MM-dd HH:mm"))
(def file-target "/tmp/garde/")

;; JIRA maintains custom fields for the PMID links and descriptions that are used
;; as evidence to justify the interpretation
;; These are listed as pairs, the first is a PMID reference, the second is
;; a textual description

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

(defn send-message
  "Send an updated dosage curation into Kafka"
  [p k v]
  (.send p (ProducerRecord. kafka-topic k v)))

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
           {:type "http://datamodel.clinicalgenome.org/terms/CG_000083"}
           interpreted-fields
           region)))

(defn jira-issues
  "Return a lazy seq of blocks of raw issues, retrieved from JIRA"
  [curation-type start-time start max-results]
  (let [query-str (str "project = ISCA AND type = \"" curation-type "\" AND status != Open AND resolution = Complete AND updated > '" start-time "' ORDER BY updated DESC")
        url "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/search"
        result (http/get url {:query-params 
                              {:jql query-str
                               :startAt start
                               :maxResults max-results}
                              :content-type "application/json"
                              :basic-auth [(System/getenv "NCBI_JIRA_USER")
                                           (System/getenv "NCBI_JIRA_PASSWORD")]})
        result-body (-> result :body json/parse-string)
        remaining (- (result-body "total") (+ start max-results))]
    (log/info "Retrieving messages from " start ", " (result-body "total") " total.")
    (if (> remaining 0)
      (lazy-seq
       (cons (result-body "issues")
             (jira-issues curation-type start-time (+ start max-results) max-results)))
      (list (result-body "issues")))))

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

(defn push-message
  "Push incoming messages to Kafka-based data exchange"
  [message producer]
  (let [msg-str (json/generate-string message)]
    (println "in push-messages")
    (pprint message)
    (.send producer (ProducerRecord. kafka-topic (:id message) msg-str))))

(defn write-message
  "Write incoming messages to file"
  [message]
  (let [key (re-find #"ISCA.*$" (:id message))
        path (str file-target key)]
    (io/make-parents path)
    (with-open [w (io/writer path)]
      (json/generate-stream message w {:pretty true}))))


;; Expects ISCA Gene Curation or ISCA Region Curation for curation types
(defn write-update-to-files
  [datetime curation-type] 
  (doseq [batch (jira-issues curation-type datetime 0 batch-size)
          message (transform-gene-issues batch)]
    (write-message message)))

(defn send-update-to-exchange
  "Update data exchange with issues modified after given time"
  [datetime producer] 
  (doseq [batch (jira-issues "ISCA Gene Curation" datetime 0 batch-size)
          message (transform-gene-issues batch)]
    (log/info "sending messages: " (with-out-str (pprint message)))
    (push-message message producer)))

(defn exchange-update-loop
  "Loop to update data exchange with messages updated after current date and time"
  []
  (while true
    (try
      (with-open [p (kafka/producer)]
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
          (send-update-to-exchange last-polled p)
          (spit last-polled-file current-time)))
      (catch Exception e (log/error e)))
    (Thread/sleep (* 1000 60 5))))

