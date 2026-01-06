package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreClosingPeriod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClosingPeriodMapper {
    CentreClosingPeriod toEntity(CentreCalendarCreateRequest.ClosingPeriodDTO dto);

    CentreCalendarCreateResponse.ClosingPeriodDTO toResponse(CentreClosingPeriod centreClosingPeriod);
}
