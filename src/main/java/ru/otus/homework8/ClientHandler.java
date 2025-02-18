package ru.otus.homework8;

import ru.otus.homework8.processors.OkProcessor;
import ru.otus.homework8.processors.RequestProcessor;
import ru.otus.homework8.processors.ShutdownProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {
    private HttpServer server;
    private Socket socket;
    private byte[] buffer;
    private int n;

    public ClientHandler(HttpServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
        this.buffer = new byte[5 * 1024 * 1024];
        n = 0;
    }

    @Override
    public void run() {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {
            while (true) {
                n = socket.getInputStream().read(buffer);
                String rawRequest = new String(buffer, 0, n);
                HttpRequest request = new HttpRequest(rawRequest);
                request.info(true);


                RequestProcessor processor;
                if (request.getMethod() == HttpMethod.GET && request.getUri().equals("/shutdown")) {
                    processor = new ShutdownProcessor();
                    processor.execute(request, out);
                    server.shutdown();
                } else {
                    // Для остальных запросов возвращаем 200 OK
                    processor = new OkProcessor();
                    processor.execute(request, out);
                }
            }
        } catch (IOException e) {
            try {
                OutputStream out = socket.getOutputStream();
                String response = "HTTP/1.1 500 Internal Server Error\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<html><body><h1>500 Internal Server Error</h1></body></html>";
                out.write(response.getBytes(StandardCharsets.UTF_8));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}