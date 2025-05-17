package com.paymint.user.command.handler;

import com.paymint.concepts.hexagonal.PrimaryAdapter;
import com.paymint.concepts.messaging.command.DomainCommandHandler;
import com.paymint.user.command.model.PublishUser;
import com.paymint.user.services.UserService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PublishUserHandler implements DomainCommandHandler<PublishUser>, PrimaryAdapter {
    private final UserService userService;

    public PublishUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Async
    @EventListener
    public void handle(PublishUser command) {
        userService.createUser(command.user());
    }
}
