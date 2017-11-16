(ns garde-manger.gene-dosage-test
  (:require [clojure.test :refer :all]
            [garde-manger.gene-dosage :refer :all]
            [garde-manger.test-data :refer :all]))

(deftest can-connect-to-jira
  (testing "Can connect to jira and retrieve issues"
        (let [m (jira-issues "ISCA Gene Curation" "2017-10-01" 0 50)]
          (is (> (count m) 0)))))

(deftest can-transform-gene-assertions
  (testing "Can transform issues recieved from JIRA into expected format"
    (let [i (map transform-issues sample-jira-issues)]
      (= i sample-translated-issues))))
