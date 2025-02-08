package ru.otus.lecture16.homework6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemsDao {
    public List<Item> selectAll() throws SQLException, ClassNotFoundException {
        List<Item> items = new ArrayList<Item>();
        Connection con = DataSource.getInstance().getConnection();
        Statement statement = con.createStatement();
        String query
                = "select * from items";
        ResultSet rs = statement.executeQuery(query); // Execute query

        while (rs.next()) {
            long id = rs.getLong(1);
            String name = rs.getString("name");
            int price = rs.getInt("price");
            items.add(new Item(id, name, price));
        }

        System.out.println(items);
        return items;
    }

    public void insert(Item item) throws SQLException, ClassNotFoundException {

        Connection con = DataSource.getInstance().getConnection();
        Statement statement = con.createStatement();
        String query = "INSERT INTO items (id, name, price) VALUES ("
                + item.getId() + ", '" + item.getName() + "', " + item.getPrice() + ")";

        statement.executeUpdate(query);
    }

    public void update(Item item) throws SQLException, ClassNotFoundException {
        Connection con = DataSource.getInstance().getConnection();
        Statement statement = null;
        try {
            // Создаём запрос на обновление цены для элемента с заданным id
            String sql = "UPDATE items SET price = " + item.getPrice() + " WHERE id = " + item.getId();

            statement = con.createStatement();
            int rowsUpdated = statement.executeUpdate(sql);

            if (rowsUpdated > 0) {
                System.out.println("Обновлено " + rowsUpdated + " запись(ей) для элемента с id = " + item.getId());
            } else {
                System.out.println("Запись с id = " + item.getId() + " не найдена.");
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
