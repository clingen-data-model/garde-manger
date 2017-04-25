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
(def output-file "data/ClinVar_interps.edn")

(def term-iri-map {"copy number gain" "http://purl.obolibrary.org/obo/SO_0001911"
                   "copy number loss" "http://purl.obolibrary.org/obo/SO_0001912"
                   "Benign" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000109"
                   "Likely benign" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000108"
                   "Uncertain significance" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000107"
                   "Likely Pathogenic" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000106"
                   "Pathogenic" "http://datamodel.clinicalgenome.org/clingen.owl#CG_000105"})

(def base-iris {:region "https://search.clinicalgenome.org/kb/regions/CV_"
                :clinvar "https://www.ncbi.nlm.nih.gov/clinvar/variation/"
                :clinvar-org "https://www.ncbi.nlm.nih.gov/clinvar/submitters/"
                :assertion "https://search.clinicalgenome.org/kb/assertions/CV_"})

;; Region(Assembly, Chromosome, [Sequence accession], innerStart, outerStart, innerStop, outerStop, [display_start, display_stop], start, stop, length, referenceAllele)
;; Interpretation: Subclass of variant interp
;; Alteration(alternateAllele, type)
;; Assertion(Alteration, Agent, Interpretation)
;; Agent(Name, Type{Organization, Individual})


(defn import-clinvar
  "Read the ClinVar XML file, generate appropriate messages, and send to exchange"
  []
  (xml/parse (io/input-stream cvxml)))

(defn rcv-type
  "return the title of the rcv"
  [el]
  (xml1-> (zip/xml-zip el)
          :ReferenceClinVarAssertion
          :MeasureSet
          :Measure
          (attr :Type)))

(defn type=
  "returns nil unless variant type equals the argument"
  [node pred]
  (xml1-> (zip/xml-zip node)
          :ReferenceClinVarAssertion
          :MeasureSet
          :Measure
          (attr= :Type pred)))

(defn construct-regions
  "Construct a basic, flat allele for import to neo"
  [node]
  (let [z (zip/xml-zip node)
        locs (xml-> z
                    :ReferenceClinVarAssertion
                    :MeasureSet
                    :Measure
                    :SequenceLocation)
        id (xml1-> z
                   :ReferenceClinVarAssertion
                   :MeasureSet
                   (attr :ID))]
    (map #(into {} (filter val {:region (str (:region base-iris) id)
                                :assembly (attr % :Assembly)
                                :chromosome (attr % :Chr)
                                :inner-start (attr % :innerStart)
                                :outer-start (attr % :outerStart)
                                :start (attr % :start)
                                :inner-stop (attr % :innerStop)
                                :outer-stop (attr % :outerStop)
                                :stop (attr % :stop)
                                :reference (attr % :referenceAllele)}))
         locs)))

(defn construct-alteration
  "Construct alteration nodes relative to a region"
  [node]
  (let [z (zip/xml-zip node)
        loc (xml1-> z :ReferenceClinVarAssertion :MeasureSet)
        id (attr z :ID)]
    (into {} (filter val {:id (str (:clinvar base-iris) id)
                          :region (str (:region base-iris) id)
                          :alteration-type (term-iri-map (xml1-> loc :Measure (attr :Type)))
                          :copy-number (some-> (xml1-> loc
                                                       :Measure
                                                       :AttributeSet
                                                       :Attribute 
                                                       (attr= :Type "AbsoluteCopyNumber")
                                                       (attr :integerValue))
                                               Integer/parseInt)}))))

(defn construct-interpretations
  "Construct interpretation nodes relative to an alteration"
  [node]
  (let [z (zip/xml-zip node)
        interps (xml-> z :ClinVarAssertion)]
    (map #(into {} (filter val {:id (str (:assertion base-iris)
                                         (xml1-> % :ClinVarAccession (attr :Acc)))
                                :version (some->
                                          (xml1-> % :ClinVarAccession (attr :Version))
                                          Integer/parseInt)
                                :date (xml1-> % :ClinicalSignificance (attr :DateLastEvaluated))
                                :agent (str (:clinvar-org base-iris)
                                        (xml1-> % :ClinVarAccession (attr :OrgID)))
                                :clinical-significance 
                                (term-iri-map (xml1-> % :ClinicalSignificance
                                                      :Description
                                                      text))}))
         interps)))

(defn construct-clingen-import
  "Deconstruct a ClinVar Set into the region, alterations, and assertions"
  [node]
  {:cx-regions (construct-regions node)
   :alteration (construct-alteration node)
   :interpretations (construct-interpretations node)})

(defn clinvar-cnvs
  "Import variants from ClinVar, filter for CNVs"
  []
  (with-open [st (io/reader cvxml)
              out (io/writer output-file)]
    (pprint (take 5  (->> st
                       xml/parse
                       :content
                       (filter #(type= % "copy number gain"))
                       (map construct-clingen-import))))
    out))

;; This code seems to avoid the 'head retention' problem
;; http://blog.korny.info/2014/03/08/xml-for-fun-and-profit.html#laziness---lose-your-head
;; (nth (->> (import-clinvar) :content (map rcv-title)) 100000)
