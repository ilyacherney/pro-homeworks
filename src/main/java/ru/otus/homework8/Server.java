package ru.otus.homework8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpRequest;

public class Server {


    public void start(int port)  {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
                    byte[] buffer = new byte[8192];
                    int n = socket.getInputStream().read(buffer);
                    if (n < 1) {
                        continue;
                    }
                    String rawRequest = new String(buffer, 0, n);

                    System.out.println("Raw request: " + rawRequest);

                    HttpRequest httpRequest = HttpRequestParser.parse(rawRequest);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
