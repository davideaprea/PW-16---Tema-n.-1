package com.business.group.shared.exception;

import java.util.List;

public record InvalidParamsErrorResponse(
        List<InvalidParamError> errors
) {
}
