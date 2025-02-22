package ru.otus.homework13;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phone> phones;

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
