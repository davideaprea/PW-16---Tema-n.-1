package com.business.group.location.http.request;

import jakarta.validation.constraints.Positive;
import lombok.experimental.FieldNameConstants;

@FieldNameConstants
public record FloorCreateRequest(
        int number,

        @Positive
        long roomsNumber
) {
}
