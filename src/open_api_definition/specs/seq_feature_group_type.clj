(ns open-api-definition.specs.seq-feature-group-type
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def seq-feature-group-type-data
  {
   (ds/opt :name) string?
   (ds/opt :id) string?
   })

(def seq-feature-group-type-spec
  (ds/spec
    {:name ::seq-feature-group-type
     :spec seq-feature-group-type-data}))
