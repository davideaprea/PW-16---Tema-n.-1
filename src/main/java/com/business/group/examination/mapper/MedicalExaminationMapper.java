package com.business.group.examination.mapper;

import com.business.group.examination.domain.entity.MedicalExamination;
import com.business.group.examination.http.dto.MedicalExaminationCreateRequest;
import com.business.group.examination.http.dto.MedicalExaminationCreateResponse;
import com.business.group.examination.http.dto.ConflictingMedicalExaminationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface MedicalExaminationMapper {
    @Mapping(target = "bookingStatus", constant = "CREATED")
    MedicalExamination toEntity(
            MedicalExaminationCreateRequest createRequest,
            LocalDateTime estimatedEndTime
    );

    MedicalExaminationCreateResponse toDTO(MedicalExamination medicalExamination);

    ConflictingMedicalExaminationResponse toResponse(MedicalExamination medicalExamination);
}
