package ru.otus.homework11;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class ItemRepository {
    private final List<Item> items = new ArrayList<Item>();

    public ItemRepository() {
        this.items.add(new Item(1, "Item 1", 10));
        this.items.add(new Item(2, "Item 2", 20));
        this.items.add(new Item(3, "Item 3", 30));
    }

    public List<Item> getItems() {
        return items;
    }

    public Optional<Item> getItemById(long id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
