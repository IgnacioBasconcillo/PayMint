package com.paymint.users.repositories;

import com.paymint.users.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public void createUser(User user);
    public List<User> getAllUsers();
    public Optional <User> getUserById(String id);
}
