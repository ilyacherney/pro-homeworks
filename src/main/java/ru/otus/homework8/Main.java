package ru.otus.homework8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Application started.");

        Server server = new Server();
        server.start(8080);
    }
}