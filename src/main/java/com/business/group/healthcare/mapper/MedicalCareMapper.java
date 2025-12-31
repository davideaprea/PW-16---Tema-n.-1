package com.business.group.healthcare.mapper;

import com.business.group.healthcare.dto.MedicalCareGetResponse;
import com.business.group.healthcare.entity.MedicalCare;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalCareMapper {
    MedicalCareGetResponse toResponse(MedicalCare medicalCare);
}
