package com.library.gateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class UserCreationException extends RuntimeException {

    public UserCreationException(String message) {
        super(message);
    }
}