package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.schedule.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.schedule.entity.ClosingPeriod;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClosingPeriodMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "calendar", ignore = true)
    ClosingPeriod toEntity(MedicalCentreCalendarCreateRequest.ClosingPeriodDTO dto);

    MedicalCentreCalendarCreateResponse.ClosingPeriodDTO toResponse(ClosingPeriod closingPeriod);
}
