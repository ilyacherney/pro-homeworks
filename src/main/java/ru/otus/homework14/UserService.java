package ru.otus.homework14;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void getUsers() {
        userRepository.findAll().forEach(System.out::println);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(() ->
                new RuntimeException("User not found: " + name));
    }
}
