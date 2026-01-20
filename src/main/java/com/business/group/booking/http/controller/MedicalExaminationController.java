package com.business.group.booking.http.controller;

import com.business.group.booking.http.dto.MedicalExaminationCreateRequest;
import com.business.group.booking.http.dto.MedicalExaminationCreateResponse;
import com.business.group.booking.domain.service.MedicalExaminationService;
import com.business.group.shared.enumeration.Routes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.Bookings.BASE)
@AllArgsConstructor
public class MedicalExaminationController implements MedicalExaminationControllerDocs {
    private final MedicalExaminationService medicalExaminationService;

    @PostMapping
    public ResponseEntity<MedicalExaminationCreateResponse> create(
            @RequestBody
            @Valid
            MedicalExaminationCreateRequest createRequest
    ) {
        return new ResponseEntity<>(medicalExaminationService.create(createRequest), HttpStatus.CREATED);
    }
}
