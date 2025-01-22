package ru.otus.homework7;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class DbMigrator {
    private final DataSource dataSource;
    final static int SEMICOLON_CODE = 59;

    public DbMigrator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void migrate() throws IOException, SQLException {
        // читаем файл init.sql
        String query = readInitFile();
//
//        // выполняем все запросы, чтобы проинициализировать БД
        executeQuery(query);
    }

    private String readInitFile() throws IOException {
        FileReader reader = new FileReader("C:\\Users\\Ilya\\IdeaProjects\\pro-homeworks\\src\\main\\resources\\init.sql");
        StringBuilder query = new StringBuilder();
        int buf = reader.read();
        while (buf != -1) {
//            if (buf == SEMICOLON_CODE) break;
            query.append((char) buf);
            buf = reader.read();
        }
        System.out.println(query);
        return String.valueOf(query);
    }

    private void executeQuery(String query) throws SQLException {
        dataSource.getStatement().executeUpdate(query);
    }
}