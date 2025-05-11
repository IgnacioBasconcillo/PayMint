package com.paymint.users.rest.controllers;

import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.id.Id;
import com.paymint.users.command.model.CreateUserCommand;
import com.paymint.users.model.entities.User;
import com.paymint.users.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@PreAuthorize("denyAll()")
public class UserCommandResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserCommandResource.class);

  @PostMapping("/create")
  @PreAuthorize("permitAll()")
  public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
    var transactionId = Id.from("USER", String.valueOf(System.currentTimeMillis())).value();
    MessagePublisher.execute(new CreateUserCommand(transactionId, userDTO));

    LOGGER.info("User creation command published with transaction ID: {}", transactionId);
    return ResponseEntity.ok("Order processed successfully");
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasRole('USER')")
  public User updateUser(@PathVariable String id, @RequestBody User user) {
    return null;
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteUser(@PathVariable String id) {}
}
