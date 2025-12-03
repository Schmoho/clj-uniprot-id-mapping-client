(ns open-api-definition.api.id-mapping-job
  (:require [open-api-definition.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [open-api-definition.specs.id-mapping-page-request :refer :all]
            [open-api-definition.specs.job-submit-response :refer :all]
            [open-api-definition.specs.job-status-response :refer :all]
            [open-api-definition.specs.term-info :refer :all]
            [open-api-definition.specs.suggestion :refer :all]
            [open-api-definition.specs.seq-feature-type :refer :all]
            [open-api-definition.specs.db-reference-type :refer :all]
            [open-api-definition.specs.id-mapping-search-result :refer :all]
            [open-api-definition.specs.job-detail-response :refer :all]
            [open-api-definition.specs.stream-result :refer :all]
            [open-api-definition.specs.property-type :refer :all]
            [open-api-definition.specs.facet-item :refer :all]
            [open-api-definition.specs.entry :refer :all]
            [open-api-definition.specs.sequence :refer :all]
            [open-api-definition.specs.id-mapping-job-request :refer :all]
            [open-api-definition.specs.problem-pair :refer :all]
            [open-api-definition.specs.id-mapping-search-result-results-inner :refer :all]
            [open-api-definition.specs.seq-feature-group-type :refer :all]
            [open-api-definition.specs.location-type :refer :all]
            [open-api-definition.specs.facet :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-details-with-http-info any?
  "Get details of ID Mapping job."
  [jobId string?]
  (check-required-params jobId)
  (call-api "/idmapping/details/{jobId}" :get
            {:path-params   {"jobId" jobId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-details job-detail-response-spec
  "Get details of ID Mapping job."
  [jobId string?]
  (let [res (:data (get-details-with-http-info jobId))]
    (if (:decode-models *api-context*)
       (st/decode job-detail-response-spec res st/string-transformer)
       res)))


(defn-spec get-status-with-http-info any?
  "Get status of ID Mapping job."
  [jobId string?]
  (check-required-params jobId)
  (call-api "/idmapping/status/{jobId}" :get
            {:path-params   {"jobId" jobId }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn-spec get-status job-status-response-spec
  "Get status of ID Mapping job."
  [jobId string?]
  (let [res (:data (get-status-with-http-info jobId))]
    (if (:decode-models *api-context*)
       (st/decode job-status-response-spec res st/string-transformer)
       res)))


(defn-spec submit-job-with-http-info any?
  "Submit ID Mapping job."
  ([] (submit-job-with-http-info nil))
  ([{:keys [id-mapping-job-request]} (s/map-of keyword? any?)]
   (call-api "/idmapping/run" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    id-mapping-job-request
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec submit-job job-submit-response-spec
  "Submit ID Mapping job."
  ([] (submit-job nil))
  ([optional-params any?]
   (let [res (:data (submit-job-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode job-submit-response-spec res st/string-transformer)
        res))))


