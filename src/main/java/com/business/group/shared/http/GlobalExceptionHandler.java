package com.business.group.shared.http;

import com.business.group.shared.exception.ConflictingResourceException;
import com.business.group.shared.exception.InvalidPayloadError;
import com.business.group.shared.exception.InvalidPayloadException;
import com.business.group.shared.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidPayloadException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public InvalidPayloadErrorResponse handle(InvalidPayloadException exception) {
        InvalidPayloadError error = exception.getError();

        return new InvalidPayloadErrorResponse(error.fieldPath(), error.cause());
    }

    @ExceptionHandler(ConflictingResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ConflictingResourceErrorResponse handle(ConflictingResourceException exception) {
        return new ConflictingResourceErrorResponse(
                exception.getSubmittedResource(),
                exception.getConflictingResources()
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle(ResourceNotFoundException exception) {
        return exception.getMessage();
    }
}
