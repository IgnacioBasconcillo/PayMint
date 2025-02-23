package com.paymint;

import com.paymint.users.models.entities.User;

public interface ConverterService {
    default User convert(String transactionId, DTO dto) throws Exception {
        throw new UnsupportedOperationException("Not implemented");
    }
}
