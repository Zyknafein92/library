package com.library.librarymicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class LibraryCreationException extends RuntimeException {
    public LibraryCreationException(String message) {
        super(message);
    }
}