package ru.otus.homework11;

public class Item {
    private long id;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String title;
    private long price;

    public Item(long id, String title, long price) {
    this.id = id;
    this.title = title;
    this.price = price;}
}
