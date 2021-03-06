(ns garde-manger.jira
  (:require [clj-http.client :as http]
            [cheshire.core :as json]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]))

(def type-description
  {:gene "ISCA Gene Curation"
   :region "ISCA Region Curation"})

(def max-results 50)

(defn issues-from [curation-type start-time start]
  (let [query-str (str "project = ISCA AND type = \"" curation-type "\" AND status != Open AND resolution = Complete AND updated > '" start-time "' ORDER BY updated DESC")
        ;;url "https://ncbijira.ncbi.nlm.nih.gov/rest/api/2/search"
        url "http://dci.clinicalgenome.org/rest/api/2/search"
        req  {:query-params 
              {:jql query-str
               :startAt start
               :maxResults max-results}
              :content-type "application/json"
              :basic-auth [(System/getenv "NCBI_JIRA_USER")
                           (System/getenv "NCBI_JIRA_PASSWORD")]}
        result (http/get url req)
        result-body (-> result :body json/parse-string)
        remaining (- (result-body "total") (+ start max-results))]
    (log/info "Retrieving messages from " start ", " (result-body "total") " total.")
    (if (> remaining 0)
      (lazy-seq
       (cons (result-body "issues")
             (issues-from curation-type start-time (+ start max-results))))
      (list (result-body "issues")))))

(defn issues
  "Return a lazy seq of blocks of raw issues, retrieved from JIRA"
  [curation-type start-time] (issues-from curation-type start-time 0))

(defn write-jira-output
  "Write records from JIRA to data/jira-output
  curation type should be one of :gene or :region"
  [output-dir curation-type]
  (println "Writing data to " output-dir)
  (let [issue-batches (issues (type-description curation-type) "2010-01-01")]
    (doseq [batch issue-batches
            issue batch]
      (with-open [w (io/writer (str output-dir (get issue "key") ".json"))]
        (json/generate-stream issue w {:pretty true}))))
  (println "Completed writing jira output"))

