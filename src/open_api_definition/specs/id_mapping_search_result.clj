(ns open-api-definition.specs.id-mapping-search-result
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.id-mapping-search-result-results-inner :refer :all]
            [open-api-definition.specs.facet :refer :all]
            [open-api-definition.specs.term-info :refer :all]
            [open-api-definition.specs.suggestion :refer :all]
            [open-api-definition.specs.problem-pair :refer :all]
            )
  (:import (java.io File)))


(def id-mapping-search-result-data
  {
   (ds/opt :results) (s/coll-of id-mapping-search-result-results-inner-spec)
   (ds/opt :facets) (s/coll-of facet-spec)
   (ds/opt :matchedFields) (s/coll-of term-info-spec)
   (ds/opt :suggestions) (s/coll-of suggestion-spec)
   (ds/opt :warnings) (s/coll-of problem-pair-spec)
   (ds/opt :obsoleteCount) int?
   (ds/opt :suggestedIds) (s/coll-of string?)
   (ds/opt :failedIds) (s/coll-of string?)
   })

(def id-mapping-search-result-spec
  (ds/spec
    {:name ::id-mapping-search-result
     :spec id-mapping-search-result-data}))
