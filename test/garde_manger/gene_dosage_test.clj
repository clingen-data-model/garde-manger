(ns garde-manger.gene-dosage-test
  (:require [clojure.test :refer :all]
            [garde-manger.gene-dosage :refer :all]
            [garde-manger.test-data :refer :all]))

(deftest can-connect-to-jira
  (testing "Can connect to jira and retrieve issues"
        (let [m (jira-issues "ISCA Gene Curation" "2017-10-01" 0 50)]
          (is (> (count m) 0)))))

(deftest can-transform-gene-assertions

  (let [i (map transform-issues sample-jira-issues)
        i1 (->> i first
                (filter
                 #(= "https://search.clinicalgenome.org/kb/gene-dosage/ISCA-6584-H"
                     (:iri %)))
                first)
        k (-> i1 keys set)
        default-keys #{:iri :evidence :type :modified :status :gene :phenotype :interpretation :description}]
    (testing "Can transform issues recieved from JIRA into expected format"
      (is (not= nil i1)))
    (testing "Transformation includes interpretation"
      (is (= "http://datamodel.clinicalgenome.org/terms/CG_000092" (:interpretation i1) )))
    (testing "Transformation includes all expected keys"
      (is (= default-keys k)))
    (testing "Transformation includes expected quantity of evidence" 
      (is (= 3 (count (:evidence i1)))))
    (testing "Evidence includes appropriate pubmed reference"
      (is (not= nil (->> i1 :evidence (filter #(= "https://www.ncbi.nlm.nih.gov/pubmed/23906836" (:evidence %)))))))))
