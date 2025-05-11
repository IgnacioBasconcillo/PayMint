package com.paymint.users.converters;

import com.paymint.concepts.ddd.Entity;
import com.paymint.exceptions.PaymintException;
import com.paymint.users.dto.UserDTO;

public interface UserToDTOConverterPort {
  default UserDTO convert(String transactionId, Entity entity) throws PaymintException {
    throw new UnsupportedOperationException("Not implemented");
  }
}
