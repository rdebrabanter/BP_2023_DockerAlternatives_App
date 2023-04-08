package com.dockerbt.api.exceptions.handler;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private int status;
    private String error;
    private LocalDateTime timestamp;
    private String message;
    private String detailMessage;
    private String path;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    ApiError(HttpStatus status, String path) {
        this();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.path = path;
    }

    ApiError(HttpStatus status, Throwable ex, String path) {
        this(status, path);
        this.message = status.getReasonPhrase();
        this.detailMessage = ex.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, Throwable ex, String path) {
        this(status, ex, path);
        this.message = message;
    }

    ApiError(HttpStatus status, String message, String detailMessage, Throwable ex, String path) {
        this(status, ex, path);
        this.message = message;
        this.detailMessage = detailMessage;
    }
}
