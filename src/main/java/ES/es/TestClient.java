package ES.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

import java.io.IOException;

public class TestClient {
    public static String HOST = "localhost";
    public static int HTTP_PORT = 9200;

    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(HOST, HTTP_PORT)
                )
        );

        GetRequest request = new GetRequest("books", "1");
        String[] includes = new String[]{"title", "published"};
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, null);
        request.fetchSourceContext(fetchSourceContext);

        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println("response:" + response.getSourceAsString());

        restHighLevelClient.close();
    }
}
