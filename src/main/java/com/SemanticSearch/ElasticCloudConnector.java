package com.SemanticSearch;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import io.github.cdimascio.dotenv.Dotenv;

public class ElasticCloudConnector {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        String elasticCloudUrl = dotenv.get("ELASTIC_CLOUD_URL");
        String username = dotenv.get("ELASTIC_USERNAME");
        String password = dotenv.get("ELASTIC_PASSWORD");

        try (RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(HttpHost.create(elasticCloudUrl))
                        .setHttpClientConfigCallback(httpClientBuilder -> {

                            CloseableHttpClient httpClient = HttpClients.custom()
                                    .setDefaultCredentialsProvider(credentialsProvider -> {
                                        credentialsProvider.setCredentials(
                                                AuthScope.ANY,
                                                new UsernamePasswordCredentials(username, password));
                                    })
                                    .build();
                            return httpClientBuilder.setHttpClient(httpClient);
                        }))) {

            System.out.println("Successfully connected to Elastic Cloud!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
