package com.business.group.schedule.service;

import com.business.group.schedule.dao.MedicalCentreCalendarDAO;
import com.business.group.schedule.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreCalendar;
import com.business.group.schedule.mapper.CentreCalendarMapper;
import com.business.group.shared.time.TimeRange;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MedicalCentreCalendarService {
    private final MedicalCentreCalendarDAO calendarDAO;
    private final CentreCalendarMapper calendarMapper;

    @Transactional
    public CentreCalendarCreateResponse create(CentreCalendarCreateRequest dto) {
        Map<DayOfWeek, List<CentreCalendarCreateRequest.TimeSlotDTO>> slotsGroupedByDay = dto
                .timeSlots()
                .stream()
                .collect(Collectors.groupingBy(CentreCalendarCreateRequest.TimeSlotDTO::dayOfWeek));

        slotsGroupedByDay.forEach((_, timeSlot) -> {
            TimeRange.checkForOverlappingRanges(timeSlot);
        });

        TimeRange.checkForOverlappingRanges(dto.closingPeriods());

        CentreCalendar savedCalendar = calendarDAO.save(calendarMapper.toEntity(dto));

        return calendarMapper.toResponse(savedCalendar);
    }
}
