(ns open-api-definition.specs.job-detail-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.problem-pair :refer :all]
            [open-api-definition.specs.problem-pair :refer :all]
            )
  (:import (java.io File)))


(def job-detail-response-data
  {
   (ds/req :from) string?
   (ds/req :to) string?
   (ds/req :ids) string?
   (ds/opt :taxId) string?
   (ds/opt :redirectURL) string?
   (ds/opt :warnings) (s/coll-of problem-pair-spec)
   (ds/opt :errors) (s/coll-of problem-pair-spec)
   })

(def job-detail-response-spec
  (ds/spec
    {:name ::job-detail-response
     :spec job-detail-response-data}))
