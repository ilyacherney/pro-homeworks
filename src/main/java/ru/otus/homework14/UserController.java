package ru.otus.homework14;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user/{name}")
    public void postUser(@PathVariable String name) {
        User user = new User(name);
        userService.addUser(user);
    }

    @PutMapping("/user/{id}/{name}")
    public void updateUserName(@PathVariable Long id, @PathVariable String name) {
        userService.updateUserName(id, name);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }



}
