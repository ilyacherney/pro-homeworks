package ru.otus.lecture16.homework6;

public class Item {
    private final long id;
    private final String name;
    private int price;

    public Item (long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
