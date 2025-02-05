package ru.otus.lecture16.homework6;

import java.sql.SQLException;

public class ItemsService {

    public void insertOneHundredItems() throws SQLException, ClassNotFoundException {
        ItemsDao dao = new ItemsDao();
        for (int i = 1; i <= 100; i++) {
            dao.insert(new Item(i, "Item" + i, 10));
        }
    }
}
