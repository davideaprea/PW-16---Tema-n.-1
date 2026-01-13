package com.business.group.healthcare.mapper;

import com.business.group.healthcare.http.dto.MedicalCareGetResponse;
import com.business.group.healthcare.domain.entity.MedicalCare;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalCareMapper {
    MedicalCareGetResponse toResponse(MedicalCare medicalCare);
}
