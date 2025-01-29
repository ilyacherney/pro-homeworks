package ru.otus.homework5;

import java.util.List;

public class Matryoshka {
    // [0] - the smallest / [9] - the biggest
    private final List<String> items;

    public Matryoshka(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }
}
