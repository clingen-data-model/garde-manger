(ns garde-manger.clinvar
  (:require [clojure.data.xml :as xml]
            [clojure.xml :as cxml]
            [clojure.java.io :as io]
            [clojure.zip :as zip]
            [clojure.data.zip :as dzip]
            [clojure.data.zip.xml :as xdzip :refer [xml-> xml1-> attr attr= text]]))

(def cvxml "data/ClinVarFullRelease_2016-11.xml")
;;(def cvxml "data/RCV000077146.xml")

(defn import-clinvar
  "Read the ClinVar XML file, generate appropriate messages, and send to exchange"
  []
  (xml/parse (io/input-stream cvxml)))

(defn rcv-title
  "return the title of the rcv"
  [el]
  (xml1-> (zip/xml-zip el)
          :Title
          text))

;; This code seems to avoid the 'head retention' problem
;; http://blog.korny.info/2014/03/08/xml-for-fun-and-profit.html#laziness---lose-your-head
;; (nth (->> (import-clinvar) :content (map rcv-title)) 100000)
