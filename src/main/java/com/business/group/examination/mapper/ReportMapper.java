package com.business.group.examination.mapper;

import com.business.group.examination.domain.entity.MedicalExaminationReport;
import com.business.group.examination.http.dto.MedicalExaminationReportCreateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    MedicalExaminationReport toEntity(String documentLink, long medicalExaminationId);

    MedicalExaminationReportCreateResponse toResponse(MedicalExaminationReport medicalExaminationReport);
}
