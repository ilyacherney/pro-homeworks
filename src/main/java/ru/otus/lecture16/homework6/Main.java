package ru.otus.lecture16.homework6;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello world!");
//        DataSource dataSource = DataSource.getInstance();
//        dataSource.connect();
//        ItemsDao itemsDao = new ItemsDao();
//        itemsDao.select();
        ItemsService itemsService = new ItemsService();
        itemsService.insertOneHundredItems();
    }
}