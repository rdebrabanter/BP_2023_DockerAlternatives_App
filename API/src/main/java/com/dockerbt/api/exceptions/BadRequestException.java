package com.dockerbt.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request received")
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = -902195337210175130L;

    public BadRequestException(String message) {
        super(message);
    }
}
