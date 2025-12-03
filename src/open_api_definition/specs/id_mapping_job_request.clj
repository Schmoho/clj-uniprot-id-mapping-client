(ns open-api-definition.specs.id-mapping-job-request
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def id-mapping-job-request-data
  {
   (ds/req :from) string?
   (ds/req :to) string?
   (ds/req :ids) string?
   (ds/opt :taxId) string?
   })

(def id-mapping-job-request-spec
  (ds/spec
    {:name ::id-mapping-job-request
     :spec id-mapping-job-request-data}))
