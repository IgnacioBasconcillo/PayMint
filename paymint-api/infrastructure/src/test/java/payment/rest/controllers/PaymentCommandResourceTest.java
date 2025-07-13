package payment.rest.controllers;

import com.paymint.concepts.messaging.MessagePublisher;
import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.payment.dto.PaymentInputDTO;
import com.paymint.payment.rest.controllers.PaymentCommandResource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

public class PaymentCommandResourceTest {
  private PaymentCommandResource paymentCommandResource;
  private PaymentInputDTO paymentInputDTO;
  private MockedStatic<MessagePublisher> messagePublisherMock;

  @BeforeEach
  public void setUp() {
    paymentCommandResource = new PaymentCommandResource();

    paymentInputDTO = new PaymentInputDTO();
    paymentInputDTO.setPaymentId("12345");
    paymentInputDTO.setAmount("100.00");
    paymentInputDTO.setCurrency("USD");
    paymentInputDTO.setPaymentMethod("Credit Card");

    messagePublisherMock = Mockito.mockStatic(MessagePublisher.class);
    doNothing().when(MessagePublisher.class);
  }

  @AfterEach
  public void tearDown() {
    messagePublisherMock.close();
  }

  @Test
  public void whenCreatePayment_thenReturnSuccess() {
    ResponseEntity<String> response = paymentCommandResource.createPayment(paymentInputDTO);

    assertEquals(200, response.getStatusCode().value());
    assertEquals("Payment created successfully", response.getBody());
  }
}
