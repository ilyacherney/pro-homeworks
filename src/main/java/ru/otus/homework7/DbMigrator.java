package ru.otus.homework7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DbMigrator {
    private DataSource dataSource;

    public DbMigrator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void migrate() throws IOException {
        // читаем файл dbinit.sql
        readInitFile();



        // выполняем все запросы, чтобы проинициализировать БД
    }

    public void readInitFile() throws IOException {
        System.out.println("***************************");
        FileReader reader = new FileReader("C:\\Users\\Ilya\\IdeaProjects\\pro-homeworks\\src\\main\\resources\\init.sql");
        int buf = reader.read();
        while (buf != -1) {
            System.out.print((char) buf);
            buf = reader.read();
        }
        System.out.println();
        System.out.println("***************************");
    }
}