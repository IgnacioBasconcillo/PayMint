package com.paymint.controllers;

import com.paymint.models.entities.User;
import com.paymint.models.valueobjects.*;
import com.paymint.services.UserService;
import com.paymint.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
        Address address = new Address(
                userDTO.getStreet(),
                userDTO.getCity(),
                userDTO.getPostalCode(),
                userDTO.getCountry()
        );

        User user = new User(
                null,
                new AccountStatus(userDTO.getAccountStatus()),
                new DateOfBirth(userDTO.getDateOfBirth()),
                new NationalId(userDTO.getNationalId()),
                new Email(userDTO.getEmail()),
                new Name(userDTO.getName()),
                new Password(userDTO.getPassword()),
                new PhoneNumber(userDTO.getPhoneNumber()),
                address,
                new Role(userDTO.getRole())
        );
        System.out.println( "aaaaa" + user.getNationalId().value());
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}