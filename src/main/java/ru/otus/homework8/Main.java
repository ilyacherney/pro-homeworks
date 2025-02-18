package ru.otus.homework8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Application started.");

        ServerProperties properties = new ServerProperties();
        int port = Integer.parseInt(properties.getProperty("port"));

        HttpServer server = new HttpServer(port);
        server.start();
    }
}