package ru.otus.homework12;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(String name) {
        return customerRepository.save(new Customer(name));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}