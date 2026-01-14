package com.business.group.shared.http;

public record InvalidPayloadErrorResponse(
        String fieldPath,
        String cause
) {
}
