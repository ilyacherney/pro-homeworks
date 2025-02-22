package ru.otus.homework12;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class App {
    private StoreService storeService;
    private ItemsService itemsService;
    private CustomerService customerService;

    public App(StoreService storeService, ItemsService itemsService, CustomerService customerService) {
        this.storeService = storeService;
        this.itemsService = itemsService;
        this.customerService = customerService;
    }



    public void run() {
        System.out.println("Welcome to the History Service");
        System.out.println("Commands:");
        System.out.println("/findItemsOfCustomer");
        System.out.println("/findCustomersOfItem");
        System.out.println("/deleteItem");
        System.out.println("/deleteCustomer");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "/findItemsOfCustomer":
                    System.out.println("Enter customer ID");
                    List<Item> items = storeService.findItemsOfCustomer(scanner.nextLong());
                    for (Item item : items) {
                        System.out.println(item);
                    }
                    break;
                case "/findCustomersOfItem":
                    System.out.println("Enter item ID");
                    List<Customer> customers = storeService.findCustomersOfItem(scanner.nextLong());
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case "/deleteItem":
                    System.out.println("Enter item ID");
                    itemsService.deleteItem(scanner.nextLong());
                    System.out.println("Item deleted.");
                    break;
                case "/deleteCustomer":
                    System.out.println("Enter customer ID");
                    customerService.deleteCustomer(scanner.nextLong());
                    System.out.println("Customer deleted.");
            }
        }
    }
}
