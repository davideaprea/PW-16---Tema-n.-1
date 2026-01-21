package com.business.group.examination.http.controller;

import com.business.group.examination.http.dto.MedicalExaminationReportCreateRequest;
import com.business.group.examination.http.dto.MedicalExaminationReportCreateResponse;
import com.business.group.shared.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Tag(name = "Medical examination reports")
public interface MedicalExaminationReportControllerDocs {
    @ApiResponse(
            responseCode = "201",
            description = "Returns the created report.",
            content = @Content(
                    schema = @Schema(
                            implementation = MedicalExaminationReportCreateResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "If the examination couldn't be found or has not been executed by the currently logged medic.",
            content = @Content(
                    schema = @Schema(
                            implementation = ResourceNotFoundException.class
                    )
            )
    )
    ResponseEntity<MedicalExaminationReportCreateResponse> create(MedicalExaminationReportCreateRequest request);

    @ApiResponse(
            responseCode = "200",
            description = "Downloads the selected report.",
            content = @Content(
                    schema = @Schema(
                            implementation = StreamingResponseBody.class
                    )
            ),
            headers = {
                    @Header(
                            name = HttpHeaders.CONTENT_DISPOSITION,
                            required = true
                    )
            }
    )
    @ApiResponse(
            responseCode = "404",
            description = "If the report couldn't be found or the currently logged user isn't authorized to access it.",
            content = @Content(
                    schema = @Schema(
                            implementation = ResourceNotFoundException.class
                    )
            )
    )
    ResponseEntity<StreamingResponseBody> getById(long id);
}
