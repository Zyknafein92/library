package com.library.bookmicroservice.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class BookCreationException extends RuntimeException {
    public BookCreationException(String message) {
        super(message);
    }
}