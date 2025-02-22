package ru.otus.homework13;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @OneToOne
    private Address address;
}
