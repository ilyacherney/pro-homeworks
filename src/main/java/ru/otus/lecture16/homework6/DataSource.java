package ru.otus.lecture16.homework6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static DataSource instance;
    private static Connection connection;

    private DataSource() {}

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private Connection connect() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost/store";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123q123w");
        Connection conn = DriverManager.getConnection(url, props);
        return conn;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            connection = connect();
        }
        return connection;
    }
}
