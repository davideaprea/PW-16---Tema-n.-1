package com.business.location.controller;

import com.business.location.dto.request.MedicalCentreCreateRequest;
import com.business.location.entity.MedicalCentre;
import com.business.location.service.MedicalCentreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/medical-centres")
public class MedicalCentreController {
    private final MedicalCentreService medicalCentreService;

    @PostMapping
    public ResponseEntity<MedicalCentre> create(@Valid @RequestBody MedicalCentreCreateRequest dto) {
        return new ResponseEntity<>(
                medicalCentreService.create(dto),
                HttpStatus.CREATED
        );
    }
}
