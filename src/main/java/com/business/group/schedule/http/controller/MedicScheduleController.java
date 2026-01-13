package com.business.group.schedule.http.controller;

import com.business.group.schedule.http.dto.MedicCalendarCreateRequest;
import com.business.group.schedule.http.dto.MedicCalendarCreateResponse;
import com.business.group.schedule.domain.service.MedicCalendarService;
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
@RequestMapping(Routes.MedicSchedules.BASE)
public class MedicScheduleController {
    private final MedicCalendarService medicCalendarService;

    @PostMapping
    public ResponseEntity<MedicCalendarCreateResponse> create(@Valid @RequestBody MedicCalendarCreateRequest dto) {
        return new ResponseEntity<>(medicCalendarService.create(dto), HttpStatus.CREATED);
    }
}
