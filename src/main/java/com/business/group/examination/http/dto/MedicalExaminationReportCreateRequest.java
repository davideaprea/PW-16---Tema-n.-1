package com.business.group.examination.http.dto;

import org.springframework.web.multipart.MultipartFile;

public record MedicalExaminationReportCreateRequest(
        long medicalExaminationId,
        MultipartFile fileContent
) {
}
