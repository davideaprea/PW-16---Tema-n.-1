package com.business.group.organization.mapper;

import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.organization.entity.ClosingPeriod;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClosingPeriodMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calendar", ignore = true)
    ClosingPeriod toEntity(MedicalCentreCalendarCreateRequest.ClosingPeriodDTO dto);
}
