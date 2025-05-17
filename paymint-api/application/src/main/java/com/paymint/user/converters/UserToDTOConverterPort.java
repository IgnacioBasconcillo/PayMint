package com.paymint.user.converters;

import com.paymint.concepts.ddd.Entity;
import com.paymint.exceptions.PaymintException;
import com.paymint.user.dto.UserSummaryDTO;

public interface UserToDTOConverterPort {
  default UserSummaryDTO convert(String transactionId, Entity entity) throws PaymintException {
    throw new UnsupportedOperationException("Not implemented");
  }
}
