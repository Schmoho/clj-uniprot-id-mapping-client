(ns open-api-definition.specs.job-submit-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def job-submit-response-data
  {
   (ds/opt :jobId) string?
   (ds/opt :message) string?
   })

(def job-submit-response-spec
  (ds/spec
    {:name ::job-submit-response
     :spec job-submit-response-data}))
