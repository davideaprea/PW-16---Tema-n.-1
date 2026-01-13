package com.business.group.shared.exception;

import java.util.List;

public record ConflictingResourceErrorResponse(
        Object submittedValue,
        List<?> conflictingResources
) {
}
