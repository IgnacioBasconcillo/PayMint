package com.paymint.users.converters;

import com.paymint.concepts.data.DTO;
import com.paymint.exceptions.PaymintException;
import com.paymint.users.model.entities.User;

public interface DTOToUserConverterPort {
  default User convert(String transactionId, DTO dto) throws PaymintException {
    throw new UnsupportedOperationException("Not implemented");
  }
}
