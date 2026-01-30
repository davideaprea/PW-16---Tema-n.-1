package com.business.group.examination.http.controller;

import com.business.group.examination.domain.dto.ReportCreateCommand;
import com.business.group.examination.domain.dto.ReportGetCommand;
import com.business.group.examination.domain.service.MedicalExaminationReportService;
import com.business.group.examination.http.dto.MedicalExaminationReportCreateRequest;
import com.business.group.examination.http.dto.MedicalExaminationReportCreateResponse;
import com.business.group.security.dto.AuthUserDetails;
import com.business.group.shared.dto.FileGetResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.InputStream;

@RestController
@RequestMapping("/reports")
@AllArgsConstructor
public class MedicalExaminationReportController implements MedicalExaminationReportControllerDocs {
    private final MedicalExaminationReportService reportService;

    @PostMapping
    public ResponseEntity<MedicalExaminationReportCreateResponse> create(
            @RequestBody
            @Valid
            MedicalExaminationReportCreateRequest request,

            @AuthenticationPrincipal
            AuthUserDetails authenticatedUser
    ) {
        return new ResponseEntity<>(
                reportService.create(new ReportCreateCommand(
                        authenticatedUser.getId(),
                        request.medicalExaminationId(),
                        request.fileContent()
                )),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponseBody> getById(
            @PathVariable long id,

            @AuthenticationPrincipal
            AuthUserDetails authenticatedUser
    ) {
        FileGetResponse response = reportService.get(new ReportGetCommand(
                id,
                authenticatedUser.getId()
        ));

        StreamingResponseBody body = outputStream -> {
            try (InputStream in = response.fileStream()) {
                in.transferTo(outputStream);
            }
        };

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"report.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(body);
    }
}
