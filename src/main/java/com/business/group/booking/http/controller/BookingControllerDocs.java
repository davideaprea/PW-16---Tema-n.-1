package com.business.group.booking.http.controller;

import com.business.group.booking.http.dto.BookingCreateRequest;
import com.business.group.booking.http.dto.BookingDTO;
import com.business.group.shared.http.ConflictingResourceErrorResponse;
import com.business.group.shared.http.InvalidPayloadErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface BookingControllerDocs {
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Creates a new booking.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = BookingCreateRequest.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "If the booking date doesn't match with the medic time slot.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = InvalidPayloadErrorResponse.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "If the selected time slot is already booked.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ConflictingResourceErrorResponse.class
                                    )
                            )
                    )
            }
    )
    ResponseEntity<BookingDTO> create(BookingCreateRequest createRequest);
}
