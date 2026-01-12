package com.business.group.location.http.response;

import java.math.BigDecimal;
import java.util.List;

public record MedicalCentreCreateResponse(
        long id,
        String email,
        String phone,
        AddressDTO address,
        List<FloorDTO> floors
) {
    public record AddressDTO(
            long id,
            String name,
            String number,
            BigDecimal latitude,
            BigDecimal longitude
    ) {
    }

    public record FloorDTO(
            long id,
            int number,
            List<RoomDTO> rooms
    ) {
        public record RoomDTO(
                long id,
                int number
        ) {
        }
    }
}
