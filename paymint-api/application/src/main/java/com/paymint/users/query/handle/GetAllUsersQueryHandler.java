package com.paymint.users.query.handle;

import com.paymint.concepts.query.DomainQueryHandler;
import com.paymint.exceptions.PaymintException;
import com.paymint.users.dto.UserDTO;
import com.paymint.users.model.entities.User;
import com.paymint.users.ports.dao.UserDao;
import com.paymint.users.converters.UserToDTOConverterPort;
import com.paymint.users.query.model.GetAllUsersQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllUsersQueryHandler
    implements DomainQueryHandler<GetAllUsersQuery, List<UserDTO>> {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetAllUsersQueryHandler.class);

  private final UserDao userDao;
  private final UserToDTOConverterPort userToDTOConverterPort;

  public GetAllUsersQueryHandler(UserDao userDao, UserToDTOConverterPort userToDTOConverterPort) {
    this.userDao = userDao;
    this.userToDTOConverterPort = userToDTOConverterPort;
  }

  @Override
  public List<UserDTO> handle(GetAllUsersQuery query) {
    try {
      List<UserDTO> userDTOList = new ArrayList<>();
      for (User user : userDao.getAllUsers()) {
        userDTOList.add(userToDTOConverterPort.convert(query.transactionId(), user));
      }
      return userDTOList;
    } catch (PaymintException e) {
      LOGGER.error("Error fetching users: {}", e.getMessage());
      throw new RuntimeException("Error fetching users", e);
    }
  }
}
