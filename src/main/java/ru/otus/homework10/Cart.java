package ru.otus.homework10;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private final List<Product> cartProducts;
    private final ProductRepository productRepository;

    public Cart(List<Product> cartProducts, ProductRepository productRepository) {
        this.cartProducts = cartProducts;
        this.productRepository = productRepository;
    }

    public void addProduct(long productId) {
        Product product = productRepository.getById(productId);
        cartProducts.add(product);
    }

    public void removeProduct(long productId) {
        cartProducts.stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .ifPresent(cartProducts::remove);
    }

    public List<Product> getProducts() {
        return cartProducts;
    }
}
