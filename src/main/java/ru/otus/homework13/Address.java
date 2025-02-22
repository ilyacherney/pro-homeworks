package ru.otus.homework13;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table (name = "addresses")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @OneToMany
    private Set<Phone> phone;
}
