package com.business.group.organization.mapper;

import com.business.group.organization.dto.MedicScheduleCreateRequest;
import com.business.group.organization.entity.MedicSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicScheduleMapper {
    MedicSchedule toEntity(MedicScheduleCreateRequest dto);
}
