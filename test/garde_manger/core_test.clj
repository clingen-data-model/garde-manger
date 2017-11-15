(ns garde-manger.core-test
  (:require [clojure.test :refer :all]
            [garde-manger.core :refer :all]
            [garde-manger.test-data :refer :all]))

(deftest a-test
  (testing "Fixed, no longer fails"
    (is (= 1 1))))

;; (deftest another-test
;;   (testing "Fix ME I'm a fail!"
;;     (is (= 0 1))))
