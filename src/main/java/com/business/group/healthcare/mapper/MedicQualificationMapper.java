package com.business.group.healthcare.mapper;

import com.business.group.healthcare.dto.MedicQualificationCreateRequest;
import com.business.group.healthcare.dto.MedicQualificationCreateResponse;
import com.business.group.healthcare.entity.MedicQualification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicQualificationMapper {
    MedicQualification toEntity(MedicQualificationCreateRequest dto);

    MedicQualificationCreateResponse toResponse(MedicQualification medicQualification);
}
