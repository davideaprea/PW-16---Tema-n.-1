package com.business.group.healthcare.dto;

import java.math.BigDecimal;

public record RoomMedicalCareCreateResponse(
        long id,
        long medicalCareId,
        long roomId,
        BigDecimal price
) {
}
