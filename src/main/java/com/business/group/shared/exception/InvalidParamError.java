package com.business.group.shared.exception;

import java.util.List;

public record InvalidParamError(
        String fieldPath,
        String cause,
        List<String> validOptions
) {
}
