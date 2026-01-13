package com.business.group.shared.http;

import com.business.group.shared.exception.InvalidParamError;

import java.util.List;

public record InvalidParamsErrorResponse(
        List<InvalidParamError> errors
) {
}
