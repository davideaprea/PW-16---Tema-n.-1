package com.business.group.examination.http.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.multipart.MultipartFile;

public record MedicalExaminationReportCreateRequest(
        @Positive
        long medicalExaminationId,

        @NotNull
        MultipartFile fileContent
) {
}
