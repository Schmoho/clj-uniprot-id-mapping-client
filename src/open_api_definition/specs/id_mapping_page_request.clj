(ns open-api-definition.specs.id-mapping-page-request
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def id-mapping-page-request-data
  {
   (ds/opt :cursor) string?
   (ds/opt :size) int?
   })

(def id-mapping-page-request-spec
  (ds/spec
    {:name ::id-mapping-page-request
     :spec id-mapping-page-request-data}))
