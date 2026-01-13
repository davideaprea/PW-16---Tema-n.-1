package com.business.group.shared.http;

import java.util.List;

public record ConflictingResourceErrorResponse(
        Object submittedValue,
        List<?> conflictingResources
) {
}
