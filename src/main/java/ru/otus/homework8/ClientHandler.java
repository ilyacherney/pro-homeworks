package ru.otus.homework8;

import java.io.IOException;
import java.net.Socket;

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
        try {
            while (true) {
                n = socket.getInputStream().read(buffer);
                String rawRequest = new String(buffer, 0, n);
                HttpRequest request = new HttpRequest(rawRequest);
                request.info(true);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}