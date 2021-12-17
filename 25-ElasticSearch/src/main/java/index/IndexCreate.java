package index;

import client.ESClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author YeYaqiao
 */
public class IndexCreate {

    //创建索引
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ESClient.getClient();
        CreateIndexRequest indexRequest = new CreateIndexRequest("java_index");
        CreateIndexResponse indexResponse = client.indices().create(indexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = indexResponse.isAcknowledged();
        System.out.println(acknowledged);
        client.close();
    }
}
