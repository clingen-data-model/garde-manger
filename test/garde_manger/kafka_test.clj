(ns garde-manger.kafka-test
  (:require [clojure.test :refer :all]
            [garde-manger.kafka :refer :all]))

(deftest can-construct-kafka-producer
  (testing "Testing construction of Kafka producer"
    (with-open [p (producer)])))
