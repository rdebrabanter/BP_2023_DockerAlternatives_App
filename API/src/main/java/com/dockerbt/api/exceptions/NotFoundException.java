package com.dockerbt.api.exceptions;

import com.dockerbt.api.domain.Status;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.util.Collection;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Record not found")
public class NotFoundException extends RuntimeException
{

    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message)
    {
        super(message);
    }

    public NotFoundException(String workRequestId, Collection<Status> statuses)
    {
        super(String.format("WorkRequest with id \"%s\" and status %s not found", workRequestId, statuses));
    }
}
