package com.business.group.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public InvalidParamsErrorResponse handle(InvalidParamsException exception) {
        return new InvalidParamsErrorResponse(exception.getInvalidParamErrors());
    }
}
