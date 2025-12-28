package com.business.location.medicalcentre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record AddressDTO(
        @NotBlank
        String name,

        @NotBlank
        String number,

        @NotNull
        BigDecimal latitude,

        @NotNull
        BigDecimal longitude,

        @Size(max = 500)
        String notes,

        @Positive
        long cityId
) {
}
