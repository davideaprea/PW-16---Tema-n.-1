package com.business.group.schedule.http.controller;

import com.business.group.schedule.http.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.http.dto.CentreCalendarCreateResponse;
import com.business.group.shared.exception.InvalidPayloadError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Medical centre calendars")
public interface MedicalCentreCalendarControllerDocs {
    @Operation(
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returns the created calendar.",
                            content = @Content(
                                    schema = @Schema(implementation = CentreCalendarCreateRequest.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "If the ranges are not valid.",
                            content = @Content(
                                    schema = @Schema(implementation = InvalidPayloadError.class)
                            )
                    )
            }
    )
    ResponseEntity<CentreCalendarCreateResponse> create(CentreCalendarCreateRequest dto);
}
