package com.paymint.user.query.handle;

import com.paymint.concepts.query.DomainQueryHandler;
import com.paymint.exceptions.PaymintException;
import com.paymint.user.converters.UserToDTOConverterPort;
import com.paymint.user.dto.UserSummaryDTO;
import com.paymint.user.exception.UserNotFoundException;
import com.paymint.user.model.aggregates.User;
import com.paymint.user.ports.dao.UserDao;
import com.paymint.user.query.model.GetUserByEmailQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GetUserByEmailQueryHandler
    implements DomainQueryHandler<GetUserByEmailQuery, UserSummaryDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetUserByEmailQueryHandler.class);
  private final UserDao userDao;
  private final UserToDTOConverterPort userToDTOConverterPort;

  public GetUserByEmailQueryHandler(
      UserDao userDao, UserToDTOConverterPort userToDTOConverterPort) {
    this.userDao = userDao;
    this.userToDTOConverterPort = userToDTOConverterPort;
  }

  @Override
  public UserSummaryDTO handle(GetUserByEmailQuery query) throws PaymintException {
    LOGGER.info("Handling GetUserByIdQuery for email: {}", query.email());

    User user =
        userDao
            .getUserByEmail(query.email())
            .orElseThrow(() -> new UserNotFoundException(query.email()));

    return convertToDTO(query.transactionId(), user);
  }

  private UserSummaryDTO convertToDTO(String transactionId, User user) throws PaymintException {
    try {
      return userToDTOConverterPort.convert(transactionId, user);
    } catch (PaymintException e) {
      LOGGER.error("Error converting user to DTO", e);
      throw new PaymintException("Error converting user", e);
    }
  }
}
