package com.business.group.healthcare.http.dto;

public record MedicQualificationCreateResponse(
        long id,
        long medicId,
        long medicalCareId
) {
}
