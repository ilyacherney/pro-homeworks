package ru.otus.homework13;

import jakarta.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
