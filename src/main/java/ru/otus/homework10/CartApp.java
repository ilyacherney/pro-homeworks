package ru.otus.homework10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CartApp {

    private final CartService cartService;
    private Cart cart;

    @Autowired
    public CartApp(CartService cartService) {
        this.cartService = cartService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a command:");
            String input = scanner.nextLine();
            processCommand(input);
        }
    }

    private void processCommand(String input) {
        if (input.equalsIgnoreCase("get cart")) {
            getCart();
        } else if (input.startsWith("add")) {
            addProductToCart(input);
        } else if (input.startsWith("remove")) {
            removeProductFromCart(input);
        } else if (input.equalsIgnoreCase("list")) {
            listProducts();
        } else {
            System.out.println("Invalid command.");
        }
    }

    private void getCart() {
        this.cart = cartService.getCart();
    }

    private void addProductToCart(String input) {
        try {
            long productId = Long.parseLong(input.split(" ")[1]);
            cartService.addProductToCart(productId, cart);
            System.out.println("Product added to the cart.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeProductFromCart(String input) {
        try {
            long productId = Long.parseLong(input.split(" ")[1]);
            cartService.removeProductFromCart(productId, cart);
            System.out.println("Product removed from the cart.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listProducts() {
        // Display a list of all products
        List<Product> products = cartService.listProducts(cart);
        System.out.println("Cart products:");
        products.forEach(product -> System.out.println(product.getId() + ": " + product.getName() + " - " + product.getPrice()));
    }
}
