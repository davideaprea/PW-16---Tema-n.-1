package com.business.group.location.http.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

public record MedicalCentreCreateRequest(
        @Email
        @NotBlank
        String email,

        @NotBlank
        @Size(max = 16)
        String phone,

        @NotNull
        @Valid
        AddressCreateRequest address,

        @NotEmpty
        List<@Valid FloorCreateRequest> floors
) {
}