package com.business.group.shared.exception;

import lombok.Getter;

@Getter
public class ConflictingResourceException extends RuntimeException {
    private final ConflictingResourceError error;

    public ConflictingResourceException(ConflictingResourceError error) {
        super("Submitted resource %s is in conflict with the followings: %s. Cause: %s."
                .formatted(
                        error.submittedPayload(),
                        error.conflictingResources(),
                        error.cause()
                ));
        this.error = error;
    }
}
