package ru.otus.homework10;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final ApplicationContext context;

    public CartService(ApplicationContext context, ProductRepository productRepository, Cart cart) {
        this.context = context;
    }

    public Cart getCart() {
        return context.getBean(Cart.class);
    }

    public void addProductToCart(long productId, Cart cart) {
        cart.addProduct(productId);
    }

    public void removeProductFromCart(long productId, Cart cart) {
        cart.removeProduct(productId);
    }

    public List<Product> listProducts(Cart cart) {
        return cart.getProducts();
    }
}
