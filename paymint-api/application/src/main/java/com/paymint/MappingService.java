package com.paymint;

import com.paymint.exceptions.PaymintException;
import com.paymint.users.dto.UserDTO;
import com.paymint.users.models.entities.User;

public interface MappingService {
    default UserDTO convert(String transactionId, User user) throws PaymintException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
