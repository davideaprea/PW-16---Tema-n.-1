package com.business.location.controller;

import com.business.location.dto.request.MedicalCentreCreateRequest;
import com.business.location.dto.response.MedicalCentreCreateResponse;
import com.business.location.dto.response.MedicalCentreGetPageResponse;
import com.business.location.service.MedicalCentreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/medical-centres")
public class MedicalCentreController {
    private final MedicalCentreService medicalCentreService;

    @PostMapping
    public ResponseEntity<MedicalCentreCreateResponse> create(@Valid @RequestBody MedicalCentreCreateRequest dto) {
        return new ResponseEntity<>(
                medicalCentreService.create(dto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<Page<MedicalCentreGetPageResponse>> search(
            @RequestParam long regionId,
            @RequestParam(required = false) String city,
            Pageable pageable
    ) {
        return ResponseEntity.ok(medicalCentreService.findByRegionAndCity(regionId, city, pageable));
    }
}
