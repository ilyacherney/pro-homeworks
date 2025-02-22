package ru.otus.homework12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        CustomerService customerService = context.getBean(CustomerService.class);
        Customer c3 = customerService.saveCustomer("Anya");
        Customer c2 = customerService.saveCustomer("Ilya");
        Customer c1 = customerService.saveCustomer("Alexey");

        ItemsService itemsService = context.getBean(ItemsService.class);
        Item i1 = itemsService.saveItem("PC", new BigDecimal(100_000));
        Item i2 = itemsService.saveItem("Car", new BigDecimal(200_000));
        Item i3 = itemsService.saveItem("House", new BigDecimal(300_000));

        StoreService storeService = context.getBean(StoreService.class);
        storeService.buy(c1, i1);
        storeService.buy(c2, i2);
        storeService.buy(c3, i3);
        storeService.buy(c2, i1);
        storeService.buy(c2, i3);

        App app = context.getBean(App.class);
        app.run();
    }
}
