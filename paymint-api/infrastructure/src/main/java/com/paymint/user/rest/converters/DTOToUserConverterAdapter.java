package com.paymint.user.rest.converters;

import com.paymint.concepts.data.DTO;
import com.paymint.user.model.valueobjects.*;
import com.paymint.user.converters.DTOToUserConverterPort;
import com.paymint.exceptions.PaymintException;
import com.paymint.user.dto.UserInputDTO;
import com.paymint.user.model.aggregates.User;
import com.paymint.user.model.enums.AccountStatus;
import com.paymint.user.model.enums.RoleType;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class DTOToUserConverterAdapter implements DTOToUserConverterPort {

  @Override
  public User convert(String transactionId, DTO dto) throws PaymintException {
    UserInputDTO userInputDTO = (UserInputDTO) dto;
    return userRequestToDomain(userInputDTO);
  }

  private User userRequestToDomain(UserInputDTO userRequest) {
    return new User(
        UserId.generate(),
        AccountStatus.valueOf(userRequest.getAccountStatus()),
        new DateOfBirth(userRequest.getDateOfBirth()),
        new NationalId(userRequest.getNationalId()),
        new Email(userRequest.getEmail()),
        new Address(
            userRequest.getStreet(),
            userRequest.getCity(),
            userRequest.getPostalCode(),
            userRequest.getCountry()),
        new PhoneNumber(userRequest.getPhoneNumber()),
        new Password(userRequest.getPassword()),
        new Name(userRequest.getName()),
        Set.of(RoleType.valueOf(userRequest.getRole())));
  }
}
