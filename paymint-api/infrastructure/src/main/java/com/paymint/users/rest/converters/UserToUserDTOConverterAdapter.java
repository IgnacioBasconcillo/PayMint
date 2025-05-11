package com.paymint.users.rest.converters;

import com.paymint.concepts.ddd.Entity;
import com.paymint.exceptions.PaymintException;
import com.paymint.users.dto.UserDTO;
import com.paymint.users.model.entities.User;
import com.paymint.users.converters.UserToDTOConverterPort;
import org.springframework.stereotype.Service;

@Service
public class UserToUserDTOConverterAdapter implements UserToDTOConverterPort {

  @Override
  public UserDTO convert(String transactionId, Entity entity) throws PaymintException {
    User user = (User) entity;
    return userToUserDto(user);
  }

  private UserDTO userToUserDto(User user) {
    UserDTO UserDTO = new UserDTO();
    UserDTO.setAccountStatus(user.getAccountStatus().value());
    UserDTO.setDateOfBirth(user.getDateOfBirth().value());
    UserDTO.setNationalId(user.getNationalId().value());
    UserDTO.setEmail(user.getEmail().value());
    UserDTO.setName(user.getName().value());
    UserDTO.setPhoneNumber(user.getPhoneNumber().value());
    UserDTO.setStreet(user.getAddress().street());
    UserDTO.setCity(user.getAddress().city());
    UserDTO.setPostalCode(user.getAddress().postalCode());
    UserDTO.setCountry(user.getAddress().country());
    UserDTO.setRole(user.getRole().value());

    return UserDTO;
  }
}
