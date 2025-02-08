package ru.otus.lecture16.homework6;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemsServiceProxy {

    private final ItemsService itemsService;

    public ItemsServiceProxy(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    public void insertOneHundredItems() throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            itemsService.insertOneHundredItems();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
    }

    public void doublePrices() throws SQLException, ClassNotFoundException {
        Connection connection = DataSource.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            itemsService.doublePrices();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
    }
}
