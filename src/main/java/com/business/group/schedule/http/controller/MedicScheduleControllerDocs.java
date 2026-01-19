package com.business.group.schedule.http.controller;

import com.business.group.schedule.http.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.http.dto.MedicCalendarCreateResponse;
import com.business.group.shared.exception.ConflictingResourceError;
import com.business.group.shared.exception.InvalidPayloadError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Medic schedules")
public interface MedicScheduleControllerDocs {
    @Operation(
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returns the created calendar.",
                            content = @Content(
                                    schema = @Schema(implementation = MedicCalendarCreateResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "If time slot ranges are not valid.",
                            content = @Content(
                                    schema = @Schema(implementation = InvalidPayloadError.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "If the selected time slot is conflicting with others.",
                            content = @Content(
                                    schema = @Schema(implementation = ConflictingResourceError.class)
                            )
                    )
            }
    )
    ResponseEntity<MedicCalendarCreateResponse> create(MedicCalendarCreateRequest dto);
}
