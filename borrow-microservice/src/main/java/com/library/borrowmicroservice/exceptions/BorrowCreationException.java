package com.library.borrowmicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class BorrowCreationException extends RuntimeException {
    public BorrowCreationException(String message) {
        super(message);
    }
}