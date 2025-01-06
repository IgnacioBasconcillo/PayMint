package com.paymint.converters;

import com.paymint.data.dtos.UserDTO;
import com.paymint.models.entities.User;
import com.paymint.models.valueobjects.*;

import java.util.UUID;

public class UserRequestConverter {
    public static User userRequestToDomain(UserDTO userRequest) {
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
                        userRequest.getCountry()
                ),
                new Role(userRequest.getRole())
        );
    }
}
