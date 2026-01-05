package com.business.group.organization.service;

import com.business.group.organization.dao.MedicalCentreCalendarDAO;
import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.organization.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.organization.entity.MedicalCentreCalendar;
import com.business.group.organization.mapper.MedicalCentreCalendarMapper;
import com.business.group.shared.time.Range;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class MedicalCentreCalendarService {
    private final MedicalCentreCalendarDAO calendarDAO;
    private final MedicalCentreCalendarMapper calendarMapper;

    @Transactional
    public MedicalCentreCalendarCreateResponse create(MedicalCentreCalendarCreateRequest dto) {
        Set<DayOfWeek> selectedDaysOfWeek = new HashSet<>();

        dto.openingDays().forEach(day -> {
            if (selectedDaysOfWeek.contains(day.dayOfWeek())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            selectedDaysOfWeek.add(day.dayOfWeek());

            Range.checkForOverlappingRanges(day.timeSlots());
        });

        Range.checkForOverlappingRanges(dto.closingPeriods());

        MedicalCentreCalendar savedCalendar = calendarDAO.save(calendarMapper.toEntity(dto));

        return calendarMapper.toResponse(savedCalendar);
    }
}
