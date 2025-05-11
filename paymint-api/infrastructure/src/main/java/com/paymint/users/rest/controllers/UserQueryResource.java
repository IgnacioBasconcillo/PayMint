package com.paymint.users.rest.controllers;

import com.paymint.concepts.query.QueryBus;
import com.paymint.id.Id;
import com.paymint.users.dto.UserDTO;
import com.paymint.users.query.model.GetAllUsersQuery;
import com.paymint.users.query.model.GetUserByIdQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@PreAuthorize("allowAll()")
public class UserQueryResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserQueryResource.class);

  @GetMapping("/{id}")
  @PreAuthorize("hasRole('USER')")
  public UserDTO getUserById(@PathVariable String id) {
    LOGGER.info("Fetching user with ID: {}", id);
    return QueryBus.execute(new GetUserByIdQuery(id));
  }

  @GetMapping("/getUsers")
  @PreAuthorize("permitAll()")
  public List<UserDTO> getAllUsers() {
    String transactionId = Id.from("USER", String.valueOf(System.currentTimeMillis())).value();
    LOGGER.info("Fetching all users");
    return QueryBus.execute(new GetAllUsersQuery(transactionId));
  }
}
