package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.schedule.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreClosingPeriod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClosingPeriodMapper {
    CentreClosingPeriod toEntity(MedicalCentreCalendarCreateRequest.ClosingPeriodDTO dto);

    MedicalCentreCalendarCreateResponse.ClosingPeriodDTO toResponse(CentreClosingPeriod centreClosingPeriod);
}
