package com.business.group.examination.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.web.multipart.MultipartFile;

public record ReportCreateCommand(
        @Positive
        long medicId,

        @Positive
        long medicalExaminationId,

        @NotNull
        MultipartFile fileContent
) {
}
