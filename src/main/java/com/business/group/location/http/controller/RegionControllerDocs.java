package com.business.group.location.http.controller;

import com.business.group.location.http.response.RegionGetResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Regions")
public interface RegionControllerDocs {
    @ApiResponse(
            responseCode = "200",
            description = "Returns all regions.",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(
                                    implementation = RegionGetResponse.class
                            )
                    )
            )
    )
    ResponseEntity<List<RegionGetResponse>> getAll();
}
