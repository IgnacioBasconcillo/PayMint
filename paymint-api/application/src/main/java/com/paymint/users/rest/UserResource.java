package com.paymint.users.rest;

import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.concepts.query.QueryBus;
import com.paymint.id.Id;
import com.paymint.users.command.CreateUserCommand;
import com.paymint.users.models.entities.User;
import com.paymint.users.query.GetAllUsersQuery;
import com.paymint.users.query.GetUserByIdQuery;
import com.paymint.users.services.UserService;
import com.paymint.users.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("denyAll()")
public class UserResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
  private final UserService userService;

  public UserResource(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  @PreAuthorize("permitAll()")
  public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
    var transactionId = Id.from("USER", String.valueOf(System.currentTimeMillis())).value();
    MessagePublisher.execute(new CreateUserCommand(transactionId, userDTO));

    LOGGER.info("User creation command published with transaction ID: {}", transactionId);
    return ResponseEntity.ok("Order processed successfully");
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasRole('USER')")
  public User getUserById(@PathVariable String id) {
    LOGGER.info("Fetching user with ID: {}", id);
    return QueryBus.execute(new GetUserByIdQuery(id));
  }

  @GetMapping("/getUsers")
  @PreAuthorize("permitAll()")
  public List<User> getAllUsers() {
    LOGGER.info("Fetching all users");
    return QueryBus.execute(new GetAllUsersQuery());
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
