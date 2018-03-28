(defproject garde-manger "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 ;;[org.apache.kafka/kafka-clients "0.11.0.1"]
                 [org.apache.kafka/kafka-clients "1.0.1"]
                 [org.clojure/data.xml "0.1.0-beta2"]
                 [org.clojure/data.zip "0.1.2"]
                 [clj-http "2.3.0"]
                 [cheshire "5.7.0"]
                 [org.clojure/tools.logging "0.4.0"]
                 [org.slf4j/slf4j-log4j12 "1.7.25"]
                 [org.clojure/tools.cli "0.3.5"]
                 ;; [org.apache.logging.log4j/log4j "2.9.1"
                 ;;  :exclusions [javax.mail/mail
                 ;;               javax.jms/jms
                 ;;               com.sun.jmdk/jmxtools
                 ;;               com.sun.jmx/jmxri]]
                 [log4j/log4j "1.2.17" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jmdk/jmxtools
                                                    com.sun.jmx/jmxri]]
                 ]
  :main ^:skip-aot garde-manger.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
