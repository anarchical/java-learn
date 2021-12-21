package client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import java.io.IOException;

/**
 * @author YeYaqiao
 */
public class ESClient {

    private static final RestClient restClient = RestClient.builder(new HttpHost("127.0.0.2", 9200)).build();

    private ESClient() {
    }

    public static RestClient getClient() {
        return restClient;
    }

    public static void close() {
        try(RestClient restClient = RestClient.builder(new HttpHost("127.0.0.2", 9200)).build()) {
            System.out.println(restClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println(ESClient.getClient().isRunning());
        System.out.println(ESClient.getClient());
        ESClient.close();
        System.out.println(ESClient.getClient());
    }

}
