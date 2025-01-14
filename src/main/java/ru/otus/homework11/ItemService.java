package ru.otus.homework11;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.getItems();
    }

    public Item getItemById(long id) {
        Optional<Item> optionalItem = itemRepository.getItemById(id);
        return optionalItem.orElse(null);
    }

    public void addItem(Item item) {
        itemRepository.addItem(item);
    }
}
