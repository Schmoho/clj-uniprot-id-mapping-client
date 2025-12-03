(ns open-api-definition.specs.entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.db-reference-type :refer :all]
            [open-api-definition.specs.seq-feature-type :refer :all]
            [open-api-definition.specs.sequence :refer :all]
            )
  (:import (java.io File)))


(def entry-data
  {
   (ds/req :accession) string?
   (ds/opt :dbReference) (s/coll-of db-reference-type-spec)
   (ds/opt :signatureSequenceMatch) (s/coll-of seq-feature-type-spec)
   (ds/req :sequence) sequence-spec
   (ds/opt :dataset) string?
   (ds/opt :uniProtKBExclusion) string?
   })

(def entry-spec
  (ds/spec
    {:name ::entry
     :spec entry-data}))
