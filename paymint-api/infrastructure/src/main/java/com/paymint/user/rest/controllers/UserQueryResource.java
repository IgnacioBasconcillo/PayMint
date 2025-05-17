package com.paymint.user.rest.controllers;

import com.paymint.concepts.query.QueryBus;
import com.paymint.exceptions.PaymintException;
import com.paymint.id.Id;
import com.paymint.user.dto.UserSummaryDTO;
import com.paymint.user.query.model.GetAllUsersQuery;
import com.paymint.user.query.model.GetUserByEmailQuery;
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

  @GetMapping("/{email}")
  @PreAuthorize("permitAll()")
  public UserSummaryDTO getUserByEmail(@PathVariable String email) throws PaymintException {
    String transactionId = Id.from("USER", String.valueOf(System.currentTimeMillis())).value();
    LOGGER.info("Fetching user with email: {}", email);
    return QueryBus.execute(new GetUserByEmailQuery(transactionId, email));
  }

  @GetMapping("/getUsers")
  @PreAuthorize("permitAll()")
  public List<UserSummaryDTO> getAllUsers() throws PaymintException {
    String transactionId = Id.from("USER", String.valueOf(System.currentTimeMillis())).value();
    LOGGER.info("Fetching all users");
    return QueryBus.execute(new GetAllUsersQuery(transactionId));
  }
}
