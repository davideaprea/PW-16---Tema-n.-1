package com.business.group.schedule.http.controller;

import com.business.group.schedule.http.dto.CentreCalendarCreateRequest;
import com.business.group.schedule.http.dto.CentreCalendarCreateResponse;
import com.business.group.schedule.domain.service.CentreCalendarService;
import com.business.group.shared.enumeration.Routes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.MedicalCentresCalendars.BASE)
public class MedicalCentreCalendarController {
    private final CentreCalendarService calendarService;

    @PostMapping
    public ResponseEntity<CentreCalendarCreateResponse> create(@RequestBody @Valid CentreCalendarCreateRequest dto) {
        return new ResponseEntity<>(calendarService.create(dto), HttpStatus.CREATED);
    }
}
