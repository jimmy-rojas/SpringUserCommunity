package com.organization.usercommunity.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppRuntimeException extends RuntimeException {

    public AppRuntimeException() {
        super("Something went wrong, please try later.");
    }
}
