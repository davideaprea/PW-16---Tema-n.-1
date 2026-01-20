package com.business.group.booking.mapper;

import com.business.group.booking.domain.entity.MedicalExamination;
import com.business.group.booking.http.dto.MedicalExaminationCreateRequest;
import com.business.group.booking.http.dto.MedicalExaminationCreateResponse;
import com.business.group.booking.http.dto.ConflictingMedicalExaminationResponse;
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
