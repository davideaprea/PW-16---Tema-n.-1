package com.business.group.location.http.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AddressCreateRequest(
        @NotBlank
        String name,

        @NotBlank
        String number,

        @NotNull
        @DecimalMin(value = "-90.0", inclusive = true)
        @DecimalMax(value = "90.0", inclusive = true)
        BigDecimal latitude,

        @NotNull
        @DecimalMin(value = "-180.0", inclusive = true)
        @DecimalMax(value = "180.0", inclusive = true)
        BigDecimal longitude,

        @Size(max = 500)
        String notes,

        @Positive
        long cityId
) {
}
