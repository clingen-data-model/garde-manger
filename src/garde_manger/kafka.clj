(ns garde-manger.kafka
  (:import java.util.Properties
           [org.apache.kafka.clients.producer KafkaProducer Producer ProducerRecord]))

(def client-properties
  {"bootstrap.servers" "tndeb:9092"
   "acks" "0"
   "key.serializer" "org.apache.kafka.common.serialization.StringSerializer"
   "value.serializer" "org.apache.kafka.common.serialization.StringSerializer"})

;; Java Properties object defining configuration of Kafka client
(defn client-configuration 
  "Create client "
  []
  (let [props (new Properties)]
    (doseq [p client-properties]
      (.put props (p 0) (p 1)))
    props))

(defn create-producer
  []
  (let [props (client-configuration)]
    (new KafkaProducer props)))

(defn send-message
  "Send msg into the defined kafka instance. Message must be serialized appropriately first"
  [msg]
  (let [producer (create-producer)
        payload (new ProducerRecord "test" "keyn" msg)]
    (println "sending message " msg)
    (.send producer payload)
    (.close producer)))
