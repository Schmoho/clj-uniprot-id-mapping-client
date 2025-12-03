(ns open-api-definition.specs.db-reference-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.property-type :refer :all]
            )
  (:import (java.io File)))


(def db-reference-type-data
  {
   (ds/opt :property) (s/coll-of property-type-spec)
   (ds/opt :type) string?
   (ds/opt :id) string?
   (ds/opt :versionI) int?
   (ds/opt :active) string?
   (ds/opt :version) int?
   (ds/opt :created) inst?
   (ds/opt :last) inst?
   })

(def db-reference-type-spec
  (ds/spec
    {:name ::db-reference-type
     :spec db-reference-type-data}))
