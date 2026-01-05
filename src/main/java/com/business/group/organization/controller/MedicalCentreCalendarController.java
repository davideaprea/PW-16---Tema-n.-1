package com.business.group.organization.controller;

import com.business.group.organization.dto.MedicalCentreCalendarCreateRequest;
import com.business.group.organization.dto.MedicalCentreCalendarCreateResponse;
import com.business.group.organization.service.MedicalCentreCalendarService;
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
@RequestMapping("/medical-centres-calendars")
public class MedicalCentreCalendarController {
    private final MedicalCentreCalendarService calendarService;

    @PostMapping
    public ResponseEntity<MedicalCentreCalendarCreateResponse> create(@RequestBody @Valid MedicalCentreCalendarCreateRequest dto) {
        return new ResponseEntity<>(calendarService.create(dto), HttpStatus.CREATED);
    }
}
