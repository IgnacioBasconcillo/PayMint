package com.paymint.users.command;

import com.paymint.concepts.messaging.command.DomainCommand;
import com.paymint.users.dto.UserDTO;

public record CreateUserCommand(String transactionId, UserDTO userDTO) implements DomainCommand {}
