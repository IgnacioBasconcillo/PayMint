package com.paymint.user.converters;

import com.paymint.concepts.data.DTO;
import com.paymint.exceptions.PaymintException;
import com.paymint.user.model.aggregates.User;

public interface DTOToUserConverterPort {
  default User convert(String transactionId, DTO dto) throws PaymintException {
    throw new UnsupportedOperationException("Not implemented");
  }
}
