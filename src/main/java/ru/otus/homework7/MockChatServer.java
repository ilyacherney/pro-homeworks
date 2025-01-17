package ru.otus.homework7;

import org.h2.tools.Server;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class MockChatServer {
    public static void main(String[] args) throws IOException {
        DataSource dataSource = null;
        Server webServer = null; //1
        try {
            dataSource = new DataSource("jdbc:h2:file:./db;MODE=PostgreSQL");
            DbMigrator migrator = new DbMigrator(dataSource);
            migrator.migrate();
            webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start(); //1
            System.out.println("Сервер чата запущен");
            dataSource.connect();

            UsersDao usersDao = new UsersDao(dataSource);
            usersDao.init();
            System.out.println(usersDao.getAllUsers());
//            usersDao.save(new User(null, "A", "A", "A"));
//            System.out.println(usersDao.getAllUsers());
            AbstractRepository<User> usersRepository = new AbstractRepository<>(dataSource, User.class);
            usersRepository.save(new User(null, "B", "B", "B"));
            System.out.println(usersDao.getAllUsers());

//            AuthenticationService authenticationService = new AuthenticationService(usersDao);
//            UsersStatisticService usersStatisticService = new UsersStatisticService(usersDao);
//            BonusService bonusService = new BonusService(dataSource);
//            bonusService.init();

//            authenticationService.register("A", "A", "A");
            // Основная работа сервера чата
            while (true);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (dataSource != null) {
                dataSource.close();
            }
            System.out.println("Сервер чата завершил свою работу");
        }
    }
}