(ns open-api-definition.api.id-mapping-results
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


(defn-spec get-mapped-entries-with-http-info any?
  "Search result of UniRef cluster (or clusters) by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (get-mapped-entries-with-http-info jobId nil))
  ([jobId string?, {:keys [query fields sort complete size]} (s/map-of keyword? any?)]
   (check-required-params jobId)
   (call-api "/idmapping/uniref/results/{jobId}" :get
             {:path-params   {"jobId" jobId }
              :header-params {}
              :query-params  {"query" query "fields" fields "sort" sort "complete" complete "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "text/plain;format=fasta"]
              :auth-names    []})))

(defn-spec get-mapped-entries id-mapping-search-result-spec
  "Search result of UniRef cluster (or clusters) by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (get-mapped-entries jobId nil))
  ([jobId string?, optional-params any?]
   (let [res (:data (get-mapped-entries-with-http-info jobId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode id-mapping-search-result-spec res st/string-transformer)
        res))))


(defn-spec get-mapped-entries1-with-http-info any?
  "Search result for a UniProtKB protein entry (or entries) mapped by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (get-mapped-entries1-with-http-info jobId nil))
  ([jobId string?, {:keys [query fields sort includeIsoform subsequence size]} (s/map-of keyword? any?)]
   (check-required-params jobId)
   (call-api "/idmapping/uniprotkb/results/{jobId}" :get
             {:path-params   {"jobId" jobId }
              :header-params {}
              :query-params  {"query" query "fields" fields "sort" sort "includeIsoform" includeIsoform "subsequence" subsequence "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/plain;format=tsv" "text/plain;format=flatfile" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "text/plain;format=fasta" "text/plain;format=gff"]
              :auth-names    []})))

(defn-spec get-mapped-entries1 id-mapping-search-result-spec
  "Search result for a UniProtKB protein entry (or entries) mapped by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (get-mapped-entries1 jobId nil))
  ([jobId string?, optional-params any?]
   (let [res (:data (get-mapped-entries1-with-http-info jobId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode id-mapping-search-result-spec res st/string-transformer)
        res))))


(defn-spec get-mapped-entries2-with-http-info any?
  "Search result of UniParc sequence entry (or entries) by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (get-mapped-entries2-with-http-info jobId nil))
  ([jobId string?, {:keys [query fields sort size]} (s/map-of keyword? any?)]
   (check-required-params jobId)
   (call-api "/idmapping/uniparc/results/{jobId}" :get
             {:path-params   {"jobId" jobId }
              :header-params {}
              :query-params  {"query" query "fields" fields "sort" sort "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "text/plain;format=fasta"]
              :auth-names    []})))

(defn-spec get-mapped-entries2 id-mapping-search-result-spec
  "Search result of UniParc sequence entry (or entries) by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (get-mapped-entries2 jobId nil))
  ([jobId string?, optional-params any?]
   (let [res (:data (get-mapped-entries2-with-http-info jobId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode id-mapping-search-result-spec res st/string-transformer)
        res))))


(defn-spec results-with-http-info any?
  "Search result by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  [jobId string?, pageRequest id-mapping-page-request]
  (check-required-params jobId pageRequest)
  (call-api "/idmapping/results/{jobId}" :get
            {:path-params   {"jobId" jobId }
             :header-params {}
             :query-params  {"pageRequest" pageRequest }
             :form-params   {}
             :content-types []
             :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"]
             :auth-names    []}))

(defn-spec results id-mapping-search-result-spec
  "Search result by a submitted job id.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  [jobId string?, pageRequest id-mapping-page-request]
  (let [res (:data (results-with-http-info jobId pageRequest))]
    (if (:decode-models *api-context*)
       (st/decode id-mapping-search-result-spec res st/string-transformer)
       res)))


(defn-spec stream-mapped-entries-with-http-info any?
  "Stream an UniRef cluster (or clusters) retrieved by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-mapped-entries-with-http-info jobId nil))
  ([jobId string?, {:keys [query fields sort complete download size]} (s/map-of keyword? any?)]
   (check-required-params jobId)
   (call-api "/idmapping/uniref/results/stream/{jobId}" :get
             {:path-params   {"jobId" jobId }
              :header-params {}
              :query-params  {"query" query "fields" fields "sort" sort "complete" complete "download" download "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "text/plain;format=fasta" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec stream-mapped-entries stream-result-spec
  "Stream an UniRef cluster (or clusters) retrieved by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-mapped-entries jobId nil))
  ([jobId string?, optional-params any?]
   (let [res (:data (stream-mapped-entries-with-http-info jobId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode stream-result-spec res st/string-transformer)
        res))))


(defn-spec stream-mapped-entries1-with-http-info any?
  "Download UniProtKB protein entry (or entries) mapped by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-mapped-entries1-with-http-info jobId nil))
  ([jobId string?, {:keys [query fields sort includeIsoform subsequence download size]} (s/map-of keyword? any?)]
   (check-required-params jobId)
   (call-api "/idmapping/uniprotkb/results/stream/{jobId}" :get
             {:path-params   {"jobId" jobId }
              :header-params {}
              :query-params  {"query" query "fields" fields "sort" sort "includeIsoform" includeIsoform "subsequence" subsequence "download" download "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/plain;format=tsv" "text/plain;format=flatfile" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "text/plain;format=fasta" "text/plain;format=gff" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec stream-mapped-entries1 stream-result-spec
  "Download UniProtKB protein entry (or entries) mapped by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-mapped-entries1 jobId nil))
  ([jobId string?, optional-params any?]
   (let [res (:data (stream-mapped-entries1-with-http-info jobId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode stream-result-spec res st/string-transformer)
        res))))


(defn-spec stream-mapped-entries2-with-http-info any?
  "Stream a UniParc sequence entry (or entries) by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-mapped-entries2-with-http-info jobId nil))
  ([jobId string?, {:keys [query fields sort download size]} (s/map-of keyword? any?)]
   (check-required-params jobId)
   (call-api "/idmapping/uniparc/results/stream/{jobId}" :get
             {:path-params   {"jobId" jobId }
              :header-params {}
              :query-params  {"query" query "fields" fields "sort" sort "download" download "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/xml" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "text/plain;format=fasta" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec stream-mapped-entries2 stream-result-spec
  "Stream a UniParc sequence entry (or entries) by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-mapped-entries2 jobId nil))
  ([jobId string?, optional-params any?]
   (let [res (:data (stream-mapped-entries2-with-http-info jobId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode stream-result-spec res st/string-transformer)
        res))))


(defn-spec stream-results-with-http-info any?
  "Stream result by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-results-with-http-info jobId nil))
  ([jobId string?, {:keys [download]} (s/map-of keyword? any?)]
   (check-required-params jobId)
   (call-api "/idmapping/stream/{jobId}" :get
             {:path-params   {"jobId" jobId }
              :header-params {}
              :query-params  {"download" download }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"]
              :auth-names    []})))

(defn-spec stream-results stream-result-spec
  "Stream result by a submitted job id.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([jobId string?, ] (stream-results jobId nil))
  ([jobId string?, optional-params any?]
   (let [res (:data (stream-results-with-http-info jobId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode stream-result-spec res st/string-transformer)
        res))))


