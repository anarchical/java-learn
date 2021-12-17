package index;

import client.ESClient;
import com.sun.media.sound.SoftTuning;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author YeYaqiao
 */
public class IndexQuery {
    //查指定索引
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ESClient.getClient();
        //查指定索引
        GetIndexRequest getIndexRequest = new GetIndexRequest("java_index");
        GetIndexResponse getIndexResponse = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getAliases());








        ESClient.close();
    }
}
