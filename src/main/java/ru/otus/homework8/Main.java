package ru.otus.homework8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Application started.");

        HttpServer server = new HttpServer(8080);
        server.start();
    }
}