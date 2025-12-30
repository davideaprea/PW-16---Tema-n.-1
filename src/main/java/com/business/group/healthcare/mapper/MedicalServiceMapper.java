package com.business.group.healthcare.mapper;

import com.business.group.healthcare.dto.MedicalServiceGetResponse;
import com.business.group.healthcare.entity.MedicalService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalServiceMapper {
    MedicalServiceGetResponse toResponse(MedicalService medicalService);
}
