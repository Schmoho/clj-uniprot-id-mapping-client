(ns open-api-definition.specs.sequence
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def sequence-data
  {
   (ds/opt :content) string?
   (ds/opt :length) int?
   (ds/opt :checksum) string?
   })

(def sequence-spec
  (ds/spec
    {:name ::sequence
     :spec sequence-data}))
