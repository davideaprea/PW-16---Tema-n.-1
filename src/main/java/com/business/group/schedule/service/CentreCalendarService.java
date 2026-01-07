package com.business.group.schedule.service;

import com.business.group.schedule.dao.MedicalCentreCalendarDAO;
import com.business.group.schedule.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.entity.CentreCalendar;
import com.business.group.schedule.mapper.CentreCalendarMapper;
import com.business.group.schedule.validator.TimeSlotValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CentreCalendarService {
    private final MedicalCentreCalendarDAO calendarDAO;
    private final CentreCalendarMapper calendarMapper;
    private final TimeSlotValidator timeSlotValidator;

    @Transactional
    public CentreCalendarCreateResponse create(CentreCalendarCreateRequest dto) {
        timeSlotValidator.checkForOverlappingSlots(dto.timeSlots());

        CentreCalendar savedCalendar = calendarDAO.save(calendarMapper.toEntity(dto));

        return calendarMapper.toResponse(savedCalendar);
    }
}
