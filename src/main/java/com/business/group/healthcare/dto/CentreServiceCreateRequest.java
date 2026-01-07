package com.business.group.healthcare.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CentreServiceCreateRequest(
        @Positive
        long medicalCareId,

        @Positive
        long roomId,

        @NotNull
        @Positive
        BigDecimal price
) {
}
