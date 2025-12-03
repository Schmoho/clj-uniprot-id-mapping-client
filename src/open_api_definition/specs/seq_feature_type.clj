(ns open-api-definition.specs.seq-feature-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.seq-feature-group-type :refer :all]
            [open-api-definition.specs.location-type :refer :all]
            )
  (:import (java.io File)))


(def seq-feature-type-data
  {
   (ds/opt :ipr) seq-feature-group-type-spec
   (ds/req :lcn) (s/coll-of location-type-spec)
   (ds/opt :database) string?
   (ds/opt :id) string?
   })

(def seq-feature-type-spec
  (ds/spec
    {:name ::seq-feature-type
     :spec seq-feature-type-data}))
