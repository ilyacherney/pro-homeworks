package ru.otus.homework12;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {
    private HistoryService historyService;
    private CustomerService customerService;
    private ItemsService itemsService;

    public StoreService(HistoryService historyService, CustomerService customerService, ItemsService itemsService) {
        this.historyService = historyService;
        this.customerService = customerService;
        this.itemsService = itemsService;
    }

    public void buy(Customer customer, Item item) {
        historyService.saveHistory(customer, item);
    }

    public List<Item> findItemsOfCustomer(Long customerId) {
        Customer customer = customerService.getCustomer(customerId).get();
        List<History> customerHistory = historyService.findCustomerHistory(customer.getId());
        List<Item> items = new ArrayList<Item>();
        for (History history : customerHistory) {
            items.add(history.getItem());
        }
        return items;
    }

    public List<Customer> findCustomersOfItem(Long itemId) {
        Item item = itemsService.getItem(itemId).get();
        List<History> itemHistory = historyService.findItemHistory(itemId);
        List<Customer> customers = new ArrayList<>();
        for (History history : itemHistory) {
            customers.add(history.getCustomer());
        }
        return customers;
    }
}
