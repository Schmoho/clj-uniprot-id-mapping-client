(ns open-api-definition.specs.property-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def property-type-data
  {
   (ds/opt :type) string?
   (ds/opt :value) string?
   })

(def property-type-spec
  (ds/spec
    {:name ::property-type
     :spec property-type-data}))
