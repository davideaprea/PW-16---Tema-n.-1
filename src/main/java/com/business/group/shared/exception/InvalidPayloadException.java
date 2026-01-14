package com.business.group.shared.exception;

import lombok.Getter;

@Getter
public class InvalidPayloadException extends RuntimeException {
    protected final InvalidPayloadError error;

    public InvalidPayloadException(InvalidPayloadError error) {
        super("""
                Invalid field %s in submitted payload %s.
                Cause: %s.
                """.formatted(
                error.fieldPath(),
                error.submittedPayload(),
                error.cause()
        ));
        this.error = error;
    }
}
