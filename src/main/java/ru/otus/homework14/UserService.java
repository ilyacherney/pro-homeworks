package ru.otus.homework14;

import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<User> userOptional =  userRepository.findByName(name);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUserName(Long id, String name) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(name);
            userRepository.save(user);
        } else {
            System.out.println("User not found");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
