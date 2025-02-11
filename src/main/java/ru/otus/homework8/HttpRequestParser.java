package ru.otus.homework8;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class HttpRequestParser {

    public static HttpRequest parse (String rawRequest) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://javarush.com"))
                .header("name1", "value1")
                .header("name2", "value2")
                .GET()
                .build();

        return request;
    }
}
