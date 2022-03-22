package demo.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public enum HttpSession {
    INSTANCE;

    private final CloseableHttpClient httpClient;
    private final String host = "http://localhost:8085";

    HttpSession() {
        httpClient = HttpClients.createDefault();
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public String getHost() {
        return host;
    }
}
