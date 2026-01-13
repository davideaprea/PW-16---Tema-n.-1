package com.business.group.shared.exception;

import java.util.Set;

public record InvalidParamError(
        Set<String> fields,
        String cause,
        Object submittedValue
) {
}
