package com.business.group.examination.mapper;

import com.business.group.examination.domain.entity.MedicalExaminationReport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    MedicalExaminationReport toEntity(String documentLink, long medicalExaminationId);
}
