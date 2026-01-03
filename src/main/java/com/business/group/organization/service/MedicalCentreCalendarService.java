package com.business.group.organization.service;

import com.business.group.organization.dao.MedicalCentreCalendarDAO;
import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest.OpeningDayDTO.TimeSlotDTO;
import com.business.group.organization.entity.MedicalCentreCalendar;
import com.business.group.organization.mapper.MedicalCentreCalendarMapper;
import com.business.group.shared.util.DateUtil;
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
    public void create(MedicalCentreCalendarCreateRequest dto) {
        Set<DayOfWeek> selectedDaysOfWeek = new HashSet<>();

        dto.openingDays().forEach(day -> {
            if (selectedDaysOfWeek.contains(day.dayOfWeek())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            selectedDaysOfWeek.add(day.dayOfWeek());

            day.timeSlots().sort((
                    first,
                    second
            ) -> DateUtil.compare(first.start(), second.start()));

            day.timeSlots().forEach(slot -> {
                if (!DateUtil.isBefore(slot.start(), slot.end())) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }
            });

            for(int i = 1; i < day.timeSlots().size(); i++) {
                final TimeSlotDTO prev = day.timeSlots().get(i - 1);
                final TimeSlotDTO curr = day.timeSlots().get(i);

                if(!DateUtil.isBefore(curr.start(), prev.end())) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }
            }
        });

        MedicalCentreCalendar savedCalendar = calendarDAO.save(calendarMapper.toEntity(dto));
    }
}
