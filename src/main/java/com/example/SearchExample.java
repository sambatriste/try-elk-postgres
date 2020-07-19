package com.example;


import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

public class SearchExample {

    public static void main(String[] args) throws IOException {

        HttpHost httpHost = new HttpHost("localhost", 9200, "http");

        try (RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(httpHost))) {
            doWithClient(client);
        }

    }

    private static void doWithClient(RestHighLevelClient client) throws IOException {
        SearchRequest request = prepareRequest();
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println("response = " + response);
    }

    private static SearchRequest prepareRequest() {
        SearchRequest request = new SearchRequest("zipcode");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(matchQuery("city", "門真市"));
        builder.size(30);
        request.source(builder);
        return request;
    }
}

