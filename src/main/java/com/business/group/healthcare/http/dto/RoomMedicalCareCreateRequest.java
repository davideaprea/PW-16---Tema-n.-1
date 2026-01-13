package com.business.group.healthcare.http.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RoomMedicalCareCreateRequest(
        @Positive
        long medicalCareId,

        @Positive
        long roomId,

        @NotNull
        @Positive
        BigDecimal price
) {
}
