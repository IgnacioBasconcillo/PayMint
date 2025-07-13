package com.paymint.payment.converters;

import com.paymint.concepts.data.DTO;
import com.paymint.exceptions.PaymintException;
import com.paymint.payment.model.aggregates.Payment;

public interface DTOToPaymentConverterPort {
    default Payment convert(String transactionId, DTO dto) throws PaymintException {
        throw new UnsupportedOperationException("Not implemented");
        }
}
