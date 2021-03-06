(ns garde-manger.kafka
  (:require [clojure.tools.logging :as log])
  (:import java.util.Properties
           [org.apache.kafka.clients.producer KafkaProducer Producer ProducerRecord]))

(def client-properties
  {"bootstrap.servers" (System/getenv "DATA_EXCHANGE_HOST")
   ;;"bootstrap.servers" "exchange.clinicalgenome.org:9093"
   "acks" "0"
   "key.serializer" "org.apache.kafka.common.serialization.StringSerializer"
   "value.serializer" "org.apache.kafka.common.serialization.StringSerializer"
   "security.protocol" "SSL"
   "ssl.truststore.location" "keys/garde.truststore.jks"
   "ssl.truststore.password" (System/getenv "GARDE_KEY_PASS")
   "ssl.keystore.location" "keys/garde.keystore.jks"
   "ssl.keystore.password" (System/getenv "GARDE_KEY_PASS")
   "ssl.key.password" (System/getenv "GARDE_KEY_PASS")
   "ssl.endpoint.identification.algorithm" ""})

;; Java Properties object defining configuration of Kafka client
(defn client-configuration 
  "Create client "
  []
  (let [props (new Properties)]
    (doseq [p client-properties]
      (.put props (p 0) (p 1)))
    props))

(defn producer
  []
  (let [props (client-configuration)]
    (new KafkaProducer props)))


(defn send-message
  "Send msg into the defined kafka instance. Message must be serialized appropriately first"
  [msg]
  (let [producer (producer)
        payload (ProducerRecord. "test" "key" msg)]
    (println "sending message " msg)
    (.send producer payload)
    (.close producer)))
