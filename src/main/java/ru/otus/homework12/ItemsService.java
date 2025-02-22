package ru.otus.homework12;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ItemsService {
    private ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }
    public Item saveItem(String name, BigDecimal price) {
        Item item = new Item(name, price);
        itemsRepository.save(item);
        return item;
    }

    public Optional<Item> getItem(Long id) {
        return itemsRepository.findById(id);
    }

    public void deleteItem(Long id) {
        itemsRepository.deleteById(id);
    }
}
