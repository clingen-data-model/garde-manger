(ns garde-manger.clinvar
  (:require [clojure.data.xml :as xml]
            [clojure.xml :as cxml]
            [clojure.java.io :as io]
            [clojure.zip :as zip]
            [clojure.data.zip :as dzip]
            [clojure.data.zip.xml :as xdzip :refer [xml-> xml1-> attr attr= text]]
            [clojure.pprint :as pp :refer [pprint]]))

;;(def cvxml "data/ClinVarFullRelease_2016-11.xml")
;;(def cvxml "data/RCV000077146.xml")
(def cvxml "data/ClinVarFullRelease_2017-0417.xml")

(defn import-clinvar
  "Read the ClinVar XML file, generate appropriate messages, and send to exchange"
  []
  (xml/parse (io/input-stream cvxml)))

(defn rcv-type
  "return the title of the rcv"
  [el]
  (xml1-> (zip/xml-zip el)
          :ClinVarSet
          :ReferenceClinVarAssertion
          :MeasureSet
          :Measure
          (attr :Type)))

(defn type=
  "returns true if variant type equals the argument"
  [node pred]
  (xml1-> (zip/xml-zip node)
          :ReferenceClinVarAssertion
          :MeasureSet
          :Measure
          (attr= :Type pred)))

(defn clinvar-cnvs
  "Import variants from ClinVar, filter for CNVs"
  []
  (with-open [st (io/reader cvxml)]
    (pprint (take 5  (->> st
                       xml/parse
                       :content
                       (filter #(type= % "copy number gain"))
                       (map rcv-type))))))

;; This code seems to avoid the 'head retention' problem
;; http://blog.korny.info/2014/03/08/xml-for-fun-and-profit.html#laziness---lose-your-head
;; (nth (->> (import-clinvar) :content (map rcv-title)) 100000)
