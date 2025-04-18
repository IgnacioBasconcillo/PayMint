package com.paymint;

import com.paymint.exceptions.PaymintException;
import com.paymint.users.models.entities.User;

public interface ConverterService {
    default User convert(String transactionId, DTO dto) throws PaymintException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
