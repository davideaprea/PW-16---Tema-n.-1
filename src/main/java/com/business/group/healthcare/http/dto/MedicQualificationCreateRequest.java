package com.business.group.healthcare.http.dto;

import jakarta.validation.constraints.Positive;

public record MedicQualificationCreateRequest(
        @Positive
        long medicId,

        @Positive
        long medicalCareId
) {
}
