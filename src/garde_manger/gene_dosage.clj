(ns garde-manger.gene-dosage
  (:require [clojure.data.xml :as xml]
            [clojure.xml :as cxml]
            [clojure.java.io :as io]
            [clojure.zip :as zip]
            [clojure.data.zip :as dzip]
            [clojure.data.zip.xml :as xdzip :refer [xml-> xml1-> attr attr= text]]))

;; JIRA maintains custom fields for the PMID links and descriptions that are used
;; as evidence to justify the interpretation
;; These are listed as pairs, the first is a PMID reference, the second is
;; a textual description
(def loss-evidence-fields
  [["customfield_10183" "customfield_10184"]
   ["customfield_10185" "customfield_10186"]
   ["customfield_10187" "customfield_10188"]])

(def gain-evidence-fields
  [["customfield_10189" "customfield_10190"]
   ["customfield_10191" "customfield_10192"]
   ["customfield_10193" "customfield_10194"]])

;; deprecate in favor of combined hashes
(def loss-score "customfield_10165")
(def gain-score "customfield_10166")

(def loss-fields {:loss-phenotype "customfield_10200"
                  :haploinsufficiency-score "customfield_10165"})

(def gain-fields {:triplosensitivity-score "customfield_10166"})

;; Gene Curation fields
;; Link to Gene:https://www.ncbi.nlm.nih.gov/gene/7428 customfield_10157

;; General fields
;; Loss phenotype omim id "customfield_10200"
;; gain phenotype omim id ???

;; Region Curation fields
;; ISCA Region Name
;; GRCh37 Genome Position:

(defn custom-field
  [z id]
  "Return text from custom field in z (zipper) given id tag"
  (let [cf (xml1-> z :customfields)]
    (xml1-> cf  :customfield (attr= :id id) :customfieldvalues :customfieldvalue text)))

(defn evidence
  "Extract evidence from subset of nodes"
  [z fields]
  (map 
   #(assoc {}  :pmid (custom-field z (first %))
           :description (custom-field z (last %))) 
   fields))


(def frontmatter-fields
  [[:id :key]
   [:status :resolution]
   [:agent :assignee]
   [:date :updated]
   [:title :title]])

;; TODO add status, resolution 
(defn frontmatter 
  "Extract metadata (title, date, agent) common to loss and gain phenotypes"
  [z]
  {:title (xml1-> z :title text)
   :date (xml1-> z :updated text)
   :agent (xml1-> z :assignee text)
   :status (xml1-> z :resolution text)
   :id (xml1-> z :key text)})


;; TODO: need to modify (should be straightforward) to accomodate 
;; triplosensitivity
(defn xml-to-interpretation
  "Transform a single item (as data.xml node) to an interpretation object"
  [item]
  (let [z (zip/xml-zip item)]
    (assoc (frontmatter z)
           :haploinsufficiency_score (custom-field z loss-score)
           :evidence_line {:has_supporting_data (evidence z loss-evidence-fields)})))

(defn item-zipper
  "Retrieve the zipper containing the list of items in interpretation"
  [file]
  (->> file
       io/input-stream
       xml/parse
       :content
       first
       :content
       (filter #(= :item (:tag %)))))

;; TODO filter for type (ISCA Gene Curation, ISCA Region Curation)
(defn transform-list
  "Transform a list of Gene Dosage items (in xml stream) into interpretation objects"
  [list]
  (println "transforming list")
  ;; Item list is buried under an <rss> tag, followed by a <channel> tag.
  ;; Channel tag includes metadata about the JIRA installation, followed by
  ;; a list of <item> tags that include the haplosensitivity assertions
  ;; The syntax below is a somewhat obtuse method of getting at the list of
  ;; <item>s, necessitated to avoid retaining a reference to the list head and
  ;; preventing garbage collection, per
  ;; http://blog.korny.info/2014/03/08/xml-for-fun-and-profit.html
  (->> list
       io/input-stream
       xml/parse
       :content
       first
       :content
       (filter #(= :item (:tag %)))
       (map xml-to-interpretation)))

;; TODO Write function to query JIRA for xml list to transform.
;; In medium term, should begin query from date last queried, order
;; by updates, capture all records (reporting errors).
