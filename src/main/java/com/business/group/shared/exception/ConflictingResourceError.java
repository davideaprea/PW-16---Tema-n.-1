package com.business.group.shared.exception;

import java.util.List;

public record ConflictingResourceError(
        Object submittedPayload,
        List<?> conflictingResources,
        String cause
) {
}
