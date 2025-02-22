package ru.otus.homework12;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
public class History {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Item item;

    public History(Customer customer, Item item) {
        this.customer = customer;
        this.item = item;
    }

    public History() {

    }

    public Item getItem() {
        return item;
    }

    public Customer getCustomer() {
        return customer;
    }
}
