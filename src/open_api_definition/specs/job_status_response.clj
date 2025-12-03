(ns open-api-definition.specs.job-status-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.problem-pair :refer :all]
            [open-api-definition.specs.problem-pair :refer :all]
            )
  (:import (java.io File)))


(def job-status-response-data
  {
   (ds/opt :jobStatus) string?
   (ds/opt :warnings) (s/coll-of problem-pair-spec)
   (ds/opt :errors) (s/coll-of problem-pair-spec)
   (ds/opt :start) inst?
   (ds/opt :totalEntries) int?
   (ds/opt :processedEntries) int?
   (ds/opt :lastUpdated) inst?
   })

(def job-status-response-spec
  (ds/spec
    {:name ::job-status-response
     :spec job-status-response-data}))
