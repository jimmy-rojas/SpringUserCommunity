package com.organization.usercommunity.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(String userName) {
        super("User not exist '" + userName + "'.");
    }
}
