package ru.otus.lecture16.homework6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemsDao {
    public Item select() throws SQLException, ClassNotFoundException {
        Connection con = DataSource.getInstance().connect();
        Statement statement = con.createStatement();
        String query
                = "select name from items where id = 4";
        ResultSet rs = statement.executeQuery(query); // Execute query
        rs.next();
        String name
                = rs.getString("name");
        System.out.println(name);
        return new Item(4, name, 0);
    }

    public void insert(Item item) throws SQLException, ClassNotFoundException {

        Connection con = DataSource.getInstance().connect();
        Statement statement = con.createStatement();
        String query = "INSERT INTO items (id, name, price) VALUES ("
                + item.id() + ", '" + item.name() + "', " + item.price() + ")";

        statement.executeUpdate(query);
    }
}
