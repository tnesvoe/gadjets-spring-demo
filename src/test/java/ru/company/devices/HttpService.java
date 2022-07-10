package ru.company.devices;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {
    public static HttpClient client() { return HttpClient.newBuilder().build(); }

    /**
     * Возвращает ответ на запрос сетевого клиента
     * @param uri
     * @return
     * @throws java.net.URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public static HttpResponse<String> serveClient(String uri) throws java.net.URISyntaxException, IOException, InterruptedException {
        URI pageUri = new URI(uri);
        HttpRequest hisRequest = HttpRequest.newBuilder(pageUri).build();

        return HttpClient.newBuilder().build().send(hisRequest, HttpResponse.BodyHandlers.ofString());
    }

}
