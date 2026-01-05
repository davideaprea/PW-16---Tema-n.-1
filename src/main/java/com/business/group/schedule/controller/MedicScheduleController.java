package com.business.group.schedule.controller;

import com.business.group.schedule.dto.MedicScheduleCreateRequest;
import com.business.group.schedule.dto.MedicScheduleCreateResponse;
import com.business.group.schedule.service.MedicScheduleService;
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
@RequestMapping("/medic-schedules")
public class MedicScheduleController {
    private final MedicScheduleService medicScheduleService;

    @PostMapping
    public ResponseEntity<MedicScheduleCreateResponse> create(@Valid @RequestBody MedicScheduleCreateRequest dto) {
        return new ResponseEntity<>(medicScheduleService.create(dto), HttpStatus.CREATED);
    }
}
