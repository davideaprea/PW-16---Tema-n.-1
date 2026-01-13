package com.business.group.shared.exception;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class InvalidParamsException extends RuntimeException {
    protected final List<InvalidParamError> invalidParamErrors;

    public InvalidParamsException(List<InvalidParamError> invalidParamErrors) {
        super("The following parameters are invalid: %s".formatted(invalidParamErrors));
        this.invalidParamErrors = List.copyOf(invalidParamErrors);
    }
}
