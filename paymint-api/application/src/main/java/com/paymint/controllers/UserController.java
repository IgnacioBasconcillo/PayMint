package com.paymint.controllers;

import com.paymint.converters.UserRequestConverter;
import com.paymint.models.entities.User;
import com.paymint.services.UserService;
import com.paymint.data.dtos.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("denyAll()")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    @PreAuthorize("permitAll()")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    @PreAuthorize("permitAll()")
    public User createUser(@RequestBody UserDTO userDTO) {
        User user = UserRequestConverter.userRequestToDomain(userDTO);
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}