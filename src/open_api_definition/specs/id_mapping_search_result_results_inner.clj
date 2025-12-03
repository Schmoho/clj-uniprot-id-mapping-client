(ns open-api-definition.specs.id-mapping-search-result-results-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def id-mapping-search-result-results-inner-data
  {
   })

(def id-mapping-search-result-results-inner-spec
  (ds/spec
    {:name ::id-mapping-search-result-results-inner
     :spec id-mapping-search-result-results-inner-data}))
