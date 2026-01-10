package com.business.group.healthcare.dto;

import java.math.BigDecimal;

public record RoomServiceGetResponse(
        long id,
        long roomId,
        BigDecimal price,
        MedicalCareGetResponse medicalCare
) {
}
