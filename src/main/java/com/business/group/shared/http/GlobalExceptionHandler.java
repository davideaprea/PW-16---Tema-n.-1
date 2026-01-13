package com.business.group.shared.http;

import com.business.group.shared.exception.ConflictingResourceException;
import com.business.group.shared.exception.InvalidParamError;
import com.business.group.shared.exception.InvalidParamException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public InvalidParamError handle(InvalidParamException exception) {
        return exception.getError();
    }

    @ExceptionHandler(ConflictingResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ConflictingResourceErrorResponse handle(ConflictingResourceException exception) {
        return new ConflictingResourceErrorResponse(
                exception.getSubmittedResource(),
                exception.getConflictingResources()
        );
    }
}
