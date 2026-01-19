package com.business.group.booking.http.controller;

import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.booking.http.dto.BookingDTO;
import com.business.group.shared.http.ConflictingResourceErrorResponse;
import com.business.group.shared.http.InvalidPayloadErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Bookings")
public interface BookingControllerDocs {
    @ApiResponse(
            responseCode = "201",
            description = "Returns the created booking.",
            content = @Content(
                    schema = @Schema(
                            implementation = BookingDTO.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "409",
            description = "If the selected time slot is already booked.",
            content = @Content(
                    schema = @Schema(
                            implementation = ConflictingResourceErrorResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "If the booking date doesn't match with the medic time slot.",
            content = @Content(
                    schema = @Schema(
                            implementation = InvalidPayloadErrorResponse.class
                    )
            )
    )
    ResponseEntity<BookingDTO> create(BookingCreateRequest createRequest);
}
