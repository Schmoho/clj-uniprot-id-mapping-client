(ns open-api-definition.specs.location-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def location-type-data
  {
   (ds/opt :start) int?
   (ds/opt :end) int?
   (ds/opt :alignment) string?
   })

(def location-type-spec
  (ds/spec
    {:name ::location-type
     :spec location-type-data}))
