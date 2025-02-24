package ru.otus.homework14;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public void getAllUsers() {
        userService.getUsers();
        System.out.println("getAllUsers");
    }

    @GetMapping("/user/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
}
