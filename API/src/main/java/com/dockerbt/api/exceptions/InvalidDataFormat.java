package com.dockerbt.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataFormat extends Exception {
    public InvalidDataFormat(String message) {
        super(message);
    }
}
