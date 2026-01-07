package com.business.group.healthcare.dto;

import java.math.BigDecimal;

public record CentreServiceCreateResponse(
        long id,
        long medicalCareId,
        long roomId,
        BigDecimal price
) {
}
