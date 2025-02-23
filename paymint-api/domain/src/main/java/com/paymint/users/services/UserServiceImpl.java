package com.paymint.users.services;

import com.paymint.users.models.entities.User;
import com.paymint.users.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User createUser(User user) {
        userRepository.createUser(user);
        return null;
    }

    @Override
    public User updateUser(String id, User user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {
    }

}
