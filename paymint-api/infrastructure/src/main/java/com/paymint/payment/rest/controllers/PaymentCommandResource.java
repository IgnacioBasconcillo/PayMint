package com.paymint.payment.rest.controllers;

import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.id.Id;
import com.paymint.payment.command.model.CreatePaymentCommand;
import com.paymint.payment.dto.PaymentInputDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentCommandResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(PaymentCommandResource.class);

  @PostMapping("/create")
  public ResponseEntity<String> createPayment(@RequestBody PaymentInputDTO paymentInputDTO) {
    var transactionId = Id.from("PAYMENT", String.valueOf(System.currentTimeMillis())).value();
    MessagePublisher.execute(new CreatePaymentCommand(transactionId, paymentInputDTO));

    LOGGER.info("Payment creation command published with transaction ID: {}", transactionId);
    return ResponseEntity.ok("Payment created successfully");
  }
}
