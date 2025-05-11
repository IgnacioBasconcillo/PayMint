package com.paymint.users.rest.converters;

import com.paymint.concepts.data.DTO;
import com.paymint.users.model.valueobjects.*;
import com.paymint.users.converters.DTOToUserConverterPort;
import com.paymint.exceptions.PaymintException;
import com.paymint.users.dto.UserDTO;
import com.paymint.users.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DTOToUserConverterAdapter implements DTOToUserConverterPort {

  @Override
  public User convert(String transactionId, DTO dto) throws PaymintException {
    UserDTO userDTO = (UserDTO) dto;
    return userRequestToDomain(userDTO);
  }

  private User userRequestToDomain(UserDTO userRequest) {
    return new User(
        new UserId(UUID.randomUUID().toString()),
        new AccountStatus(userRequest.getAccountStatus()),
        new DateOfBirth(userRequest.getDateOfBirth()),
        new NationalId(userRequest.getNationalId()),
        new Email(userRequest.getEmail()),
        new Name(userRequest.getName()),
        new Password(userRequest.getPassword()),
        new PhoneNumber(userRequest.getPhoneNumber()),
        new Address(
            userRequest.getStreet(),
            userRequest.getCity(),
            userRequest.getPostalCode(),
            userRequest.getCountry()),
        new Role(userRequest.getRole()));
  }
}
