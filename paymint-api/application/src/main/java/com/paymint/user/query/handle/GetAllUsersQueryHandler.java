package com.paymint.user.query.handle;

import com.paymint.concepts.query.DomainQueryHandler;
import com.paymint.exceptions.PaymintException;
import com.paymint.user.dto.UserSummaryDTO;
import com.paymint.user.model.aggregates.User;
import com.paymint.user.ports.dao.UserDao;
import com.paymint.user.converters.UserToDTOConverterPort;
import com.paymint.user.query.model.GetAllUsersQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllUsersQueryHandler
    implements DomainQueryHandler<GetAllUsersQuery, List<UserSummaryDTO>> {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetAllUsersQueryHandler.class);

  private final UserDao userDao;
  private final UserToDTOConverterPort userToDTOConverterPort;

  public GetAllUsersQueryHandler(UserDao userDao, UserToDTOConverterPort userToDTOConverterPort) {
    this.userDao = userDao;
    this.userToDTOConverterPort = userToDTOConverterPort;
  }

  @Override
  public List<UserSummaryDTO> handle(GetAllUsersQuery query) throws PaymintException {
    try {
      List<UserSummaryDTO> userSummaryDTOList = new ArrayList<>();
      for (User user : userDao.getAllUsers()) {
        userSummaryDTOList.add(userToDTOConverterPort.convert(query.transactionId(), user));
      }
      return userSummaryDTOList;
    } catch (PaymintException e) {
      LOGGER.error("Error fetching users: {}", e.getMessage());
      throw new PaymintException("Error fetching users", e);
    }
  }
}
