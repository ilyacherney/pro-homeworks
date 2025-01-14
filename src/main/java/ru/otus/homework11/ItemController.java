package ru.otus.homework11;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/api/v1/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/api/v1/items/{id}")
    public Item getItemById(@PathVariable long id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/api/v1/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }
}
