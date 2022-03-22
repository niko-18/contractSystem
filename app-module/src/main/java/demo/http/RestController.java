package demo.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestController {
    private static final CloseableHttpClient httpClient = HttpSession.INSTANCE.getHttpClient();

    public static <T> List<T> getObjects(Class<T> c) throws IOException {
        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
        String urlRequest = (HttpSession.INSTANCE.getHost() + "/" + c.getSimpleName().toLowerCase());
        HttpGet httpGet = new HttpGet(urlRequest);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            return gson.fromJson(EntityUtils.toString(response.getEntity()), TypeToken.getParameterized(ArrayList.class, c).getType());
        } finally {
            httpGet.releaseConnection();
        }
    }
}
