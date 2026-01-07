package com.business.group.healthcare.dto;

public record MedicServiceCreateResponse(
        long id,
        long medicId,
        long medicalCareId
) {
}
