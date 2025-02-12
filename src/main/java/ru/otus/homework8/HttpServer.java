package ru.otus.homework8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private int port;
    private static final Logger LOGGER = LogManager.getLogger(HttpServer.class.getName());

    public HttpServer(int port) {
        this.port = port;
    }


    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Server started at port: " + port);
                Socket socket = serverSocket.accept();
                ExecutorService executorService = Executors.newFixedThreadPool(3);
                executorService.execute(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}