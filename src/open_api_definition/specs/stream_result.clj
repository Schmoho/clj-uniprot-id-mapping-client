(ns open-api-definition.specs.stream-result
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.id-mapping-search-result-results-inner :refer :all]
            )
  (:import (java.io File)))


(def stream-result-data
  {
   (ds/opt :results) (s/coll-of id-mapping-search-result-results-inner-spec)
   (ds/opt :error) string?
   })

(def stream-result-spec
  (ds/spec
    {:name ::stream-result
     :spec stream-result-data}))
