(defproject garde-manger "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.apache.kafka/kafka-clients "0.11.0.1"]
                 [org.clojure/data.xml "0.1.0-beta2"]
                 [org.clojure/data.zip "0.1.2"]
                 [clj-http "2.3.0"]
                 [cheshire "5.7.0"]]
  :main ^:skip-aot garde-manger.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
