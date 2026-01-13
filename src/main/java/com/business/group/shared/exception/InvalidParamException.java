package com.business.group.shared.exception;

import lombok.Getter;

@Getter
public abstract class InvalidParamException extends RuntimeException {
    protected final InvalidParamError error;

    public InvalidParamException(InvalidParamError error) {
        super("The following parameters are invalid: %s".formatted(error));
        this.error = error;
    }
}
