package com.business.group.examination.http.dto;

public record MedicalExaminationReportCreateResponse(
        long id,
        String documentLink,
        long medicalExaminationId
) {
}
