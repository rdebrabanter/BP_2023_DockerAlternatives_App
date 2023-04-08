package com.dockerbt.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidStatusException extends Exception {
    public InvalidStatusException(String message) {
        super(message);
    }
}
