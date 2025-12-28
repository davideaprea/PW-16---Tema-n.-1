package com.business.location.dto;

import com.business.location.annotation.Contiguous;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record MedicalCentreDTO(
        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(max = 16)
        String phone,

        @NotNull
        @Valid
        AddressDTO address,

        @Contiguous
        @NotEmpty
        List<@Valid FloorDTO> floors
) {
}
