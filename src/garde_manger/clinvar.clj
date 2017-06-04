(ns garde-manger.clinvar
  (:require [clojure.data.xml :as xml]
            [clojure.xml :as cxml]
            [clojure.java.io :as io]
            [clojure.zip :as zip]
            [clojure.data.zip :as dzip]
            [clojure.data.zip.xml :as xdzip :refer [xml-> xml1-> attr attr= text]]
            [clojure.pprint :as pp :refer [pprint]]))

;; TODO there seems to be an error with the ClinVar variation id, 

;; https://www.ncbi.nlm.nih.gov/clinvar/variation/202214/
;; gets ID https://www.ncbi.nlm.nih.gov/clinvar/variation/14466133 in our system
;; Probably misusing ID from XML

;;(def cvxml "data/ClinVarFullRelease_2016-11.xml")
;;(def cvxml "data/RCV000077146.xml")
(def cvxml "data/clinvar.xml")
(def output-file "data/clinvar_interps.edn")

(def term-iri-map {"copy number gain" "http://purl.obolibrary.org/obo/SO_0001911"
                   "copy number loss" "http://purl.obolibrary.org/obo/SO_0001912"
                   "Benign" "http://datamodel.clinicalgenome.org/terms/CG_000109"
                   "Likely benign" "http://datamodel.clinicalgenome.org/terms/CG_000108"
                   "Uncertain significance" "http://datamodel.clinicalgenome.org/terms/CG_000107"
                   "Likely pathogenic" "http://datamodel.clinicalgenome.org/terms/CG_000106"
                   "Pathogenic" "http://datamodel.clinicalgenome.org/terms/CG_000105"})

;; TODO import this term in OWL: http://datamodel.clinicalgenome.org/terms/CG_000110 (Region Context)

(def base-iris {:region "https://search.clinicalgenome.org/kb/regions/CVV_"
                :region-context "https://search.clinicalgenome.org/kb/regions/CVMS_"
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
    (map #(into {} (filter val {:id (str (:region-context base-iris) id "-"
                                         (attr % :Assembly))
                                :region (str (:region base-iris) id)
                                :assembly (attr % :Assembly)
                                :chromosome (attr % :Chr)
                                :inner-start (attr % :innerStart)
                                :outer-start (attr % :outerStart)
                                :start (attr % :start)
                                :inner-stop (attr % :innerStop)
                                :outer-stop (attr % :outerStop)
                                :stop (attr % :stop)
                                :reference (attr % :referenceAllele)
                                ;; region context/contextual region
                                :type "http://datamodel.clinicalgenome.org/terms/CG_000117"}))
         locs)))

(defn construct-alteration
  "Construct alteration nodes relative to a region"
  [node]
  (let [z (zip/xml-zip node)
        loc (xml1-> z :ReferenceClinVarAssertion :MeasureSet)
        id (xml1-> z
                   :ReferenceClinVarAssertion
                   :MeasureSet
                   (attr :ID))]
    (into {} (filter val {:id (str (:clinvar base-iris) id)
                          :region (str (:region base-iris) id)
                          ;; Alteration type is directly analogous SO type
                          ;; May want to include subtype eventually so importer knows
                          ;; how to handle.
                          :type (term-iri-map (xml1-> loc :Measure (attr :Type)))
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
        interps (xml-> z :ClinVarAssertion)
        var (xml1-> z
                    :ReferenceClinVarAssertion
                    :MeasureSet
                    (attr :ID))]
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
                                                      text))
                                :type "http://datamodel.clinicalgenome.org/terms/CG_000083"
                                :variation (str (:clinvar base-iris) var)}))
         interps)))

(defn construct-clingen-import
  "Deconstruct a ClinVar Set into the region, alterations, and assertions"
  [node]
  (concat [(construct-alteration node)]
          (construct-regions node)
          (construct-interpretations node)))

(defn clinvar-cnvs
  "Import variants from ClinVar, filter for CNVs"
  []
  (with-open [st (io/reader cvxml)
              out (io/writer output-file)]
    (pprint   (->> st
                   xml/parse
                   :content
                   (filter #(or (type= % "copy number loss")
                                (type= % "copy number gain")))
                   (mapcat construct-clingen-import)
                   (take 100)) out)))

;; This code seems to avoid the 'head retention' problem
;; http://blog.korny.info/2014/03/08/xml-for-fun-and-profit.html#laziness---lose-your-head
;; (nth (->> (import-clinvar) :content (map rcv-title)) 100000)
