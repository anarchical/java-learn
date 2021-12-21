package doc;

import client.ESClient;
import org.elasticsearch.client.RestClient;

/**
 * @author YeYaqiao
 */
public class DocCreate {

    public static void main(String[] args) {
        RestClient client = ESClient.getClient();


        ESClient.close();
    }
}
