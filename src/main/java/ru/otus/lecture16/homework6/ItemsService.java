package ru.otus.lecture16.homework6;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsService {

    public void insertOneHundredItems() throws SQLException, ClassNotFoundException {
        ItemsDao dao = new ItemsDao();
        for (int i = 1; i <= 100; i++) {
//            if (i == 6) dao.insert(new Item(1, "Hundred", 1000)); // тест ошибки
            dao.insert(new Item(i, "Item" + i, (i * 10)));
            System.out.println("Item" + i + " inserted");
        }
    }

    public void doublePrices() throws SQLException, ClassNotFoundException {
        ItemsDao dao = new ItemsDao();
        List<Item> items = new ItemsDao().selectAll();
        for (Item item : items) {
            int newPrice =  item.getPrice() * 2;
            item.setPrice(newPrice);
            dao.update(item);
        }
    }
}
