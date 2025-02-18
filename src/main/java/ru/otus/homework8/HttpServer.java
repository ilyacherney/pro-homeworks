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
    private volatile boolean running = true;
    private ServerSocket serverSocket;
    private static final Logger LOGGER = LogManager.getLogger(HttpServer.class.getName());

    public HttpServer(int port) {
        this.port = port;
    }


    public void start() throws IOException {
        try {
            while (running) {
                serverSocket = new ServerSocket(port);
                System.out.println("Server started at port: " + port);
                Socket socket = serverSocket.accept();
                int threadPoolSize = Integer.parseInt(ServerProperties.getProperty("thread.pool.size"));
                ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
                executorService.execute(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        running = false;
        try {
            if(serverSocket != null && !serverSocket.isClosed()){
                serverSocket.close();
            }
            System.out.println("Server is shutting down.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}