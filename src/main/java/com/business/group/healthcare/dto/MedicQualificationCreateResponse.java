package com.business.group.healthcare.dto;

public record MedicQualificationCreateResponse(
        long id,
        long medicId,
        long medicalCareId
) {
}
