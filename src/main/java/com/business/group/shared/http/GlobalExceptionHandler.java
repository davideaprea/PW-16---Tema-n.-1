package com.business.group.shared.http;

import com.business.group.shared.exception.*;
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
        ConflictingResourceError error = exception.getError();

        return new ConflictingResourceErrorResponse(
                error.cause(),
                error.conflictingResources()
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle(ResourceNotFoundException exception) {
        return exception.getMessage();
    }
}
