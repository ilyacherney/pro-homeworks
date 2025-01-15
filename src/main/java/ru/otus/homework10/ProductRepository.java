package ru.otus.homework10;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private final List<Product> products;

    public ProductRepository(List<Product> products) {
        this.products = products;
        initializeProducts();
    }

    private void initializeProducts() {
        products.add(new Product(1, "Product 1", 10.99));
        products.add(new Product(2, "Product 2", 15.49));
        products.add(new Product(3, "Product 3", 7.99));
        products.add(new Product(4, "Product 4", 19.99));
        products.add(new Product(5, "Product 5", 25.49));
        products.add(new Product(6, "Product 6", 9.99));
        products.add(new Product(7, "Product 7", 12.99));
        products.add(new Product(8, "Product 8", 22.49));
        products.add(new Product(9, "Product 9", 30.99));
        products.add(new Product(10, "Product 10", 18.49));
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getAll() {
        return products;
    }

    public Product getById (long id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such product"));
    }

    public void removeById(long id) {
        products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .ifPresent(products::remove);
    }
}
