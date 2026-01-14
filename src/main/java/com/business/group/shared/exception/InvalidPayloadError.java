package com.business.group.shared.exception;

public record InvalidPayloadError(
        String fieldPath,
        String cause,
        Object submittedPayload
) {
}
