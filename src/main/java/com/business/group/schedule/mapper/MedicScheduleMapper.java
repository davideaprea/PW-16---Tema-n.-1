package com.business.group.schedule.mapper;

import com.business.group.schedule.dto.MedicScheduleCreateRequest;
import com.business.group.schedule.dto.MedicScheduleCreateResponse;
import com.business.group.schedule.entity.MedicSchedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicScheduleMapper {
    MedicSchedule toEntity(MedicScheduleCreateRequest dto);

    MedicScheduleCreateResponse toResponse(MedicSchedule medicSchedule);
}
