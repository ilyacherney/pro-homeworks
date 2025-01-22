package ru.otus.homework7;

import org.h2.tools.Server;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class MockChatServer {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        DataSource dataSource = null;
        Server webServer = null; //1
        try {
            dataSource = new DataSource("jdbc:h2:file:./db;MODE=PostgreSQL");
            DbMigrator migrator = new DbMigrator(dataSource);
            webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start(); //1
            System.out.println("Сервер чата запущен");
            dataSource.connect();
            migrator.migrate();

            AbstractRepository<User> usersRepository = new AbstractRepository<>(dataSource, User.class);
            usersRepository.save(new User(5L, "ilya123", "123q123e", "ilya"));
            usersRepository.findById(5L);
            usersRepository.findAll();
            usersRepository.deleteById(6L);


            User user1 = new User();
            user1.setId(38L);
            usersRepository.update(user1, "password", "kjh");

            while (true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataSource != null) {
                dataSource.close();
            }
            System.out.println("Сервер чата завершил свою работу");
        }
    }
}