package com.business.group.healthcare.http.dto;

import java.time.Duration;

public record MedicalCareGetResponse(
        long id,
        String name,
        String description,
        Duration duration
) {
}
