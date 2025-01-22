package ru.otus.homework7;

import java.sql.*;

public class AuthenticationService {
    private UsersDao usersDao;

    public AuthenticationService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void register(String login, String password, String nickname) throws SQLException {
        usersDao.save(new User(null, login, password, nickname));
    }
}
