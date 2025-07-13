package com.paymint.user.rest.converters;

import com.paymint.concepts.ddd.Entity;
import com.paymint.exceptions.PaymintException;
import com.paymint.user.dto.UserSummaryDTO;
import com.paymint.user.model.aggregates.User;
import com.paymint.user.converters.UserToDTOConverterPort;
import org.springframework.stereotype.Service;

@Service
public class UserToUserDTOConverterAdapter implements UserToDTOConverterPort {

  @Override
  public UserSummaryDTO convert(String transactionId, Entity entity) throws PaymintException {
    User user = (User) entity;
    return userToUserDto(user);
  }

  private UserSummaryDTO userToUserDto(User user) {
    UserSummaryDTO userSummaryDTO = new UserSummaryDTO();
    userSummaryDTO.setAccountStatus(user.getAccountStatus().name());
    userSummaryDTO.setDateOfBirth(user.getDateOfBirth().value());
    userSummaryDTO.setNationalId(user.getNationalId().value());
    userSummaryDTO.setEmail(user.getEmail().value());
    userSummaryDTO.setName(user.getName().value());
    userSummaryDTO.setPhoneNumber(user.getPhoneNumber().value());
    userSummaryDTO.setStreet(user.getAddress().street());
    userSummaryDTO.setCity(user.getAddress().city());
    userSummaryDTO.setPostalCode(user.getAddress().postalCode());
    userSummaryDTO.setCountry(user.getAddress().country());
    userSummaryDTO.setRole(user.getRole().toString());

    return userSummaryDTO;
  }
}
