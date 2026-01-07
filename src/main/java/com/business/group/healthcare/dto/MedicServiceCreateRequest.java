package com.business.group.healthcare.dto;

import jakarta.validation.constraints.Positive;

public record MedicServiceCreateRequest(
        @Positive
        long medicId,

        @Positive
        long medicalCareId
) {
}
