package com.dockerbt.api.exceptions.handler;

import com.dockerbt.api.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NotFoundException.class, Exception.class})
    public ResponseEntity<Object> handleCustomException(final Exception ex, final ServletWebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return handleExceptionInternal(ex, null, new HttpHeaders(), status, request);
    }

    protected ResponseEntity<Object> handleExceptionInternalWithMessage(Exception ex, String errorMessage, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError error = new ApiError(status, errorMessage, ex.getLocalizedMessage(), ex, ((ServletWebRequest)request).getRequest().getRequestURI());
        return super.handleExceptionInternal(ex, error, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus httpStatus, WebRequest request) {
        HttpStatus status = httpStatus;
        String reason = httpStatus.getReasonPhrase();
        ResponseStatus responseStatus = ex.getClass().getDeclaredAnnotation(ResponseStatus.class);

        if(responseStatus != null) {
            status = responseStatus.value();
            reason = responseStatus.reason();
        }
        ApiError error = new ApiError(status, reason, ex.getLocalizedMessage(), ex, ((ServletWebRequest)request).getRequest().getRequestURI());
        return super.handleExceptionInternal(ex, error, headers, status, request);
    }
}