package com.business.group.examination.http.controller;

import com.business.group.examination.http.dto.MedicalExaminationCreateRequest;
import com.business.group.examination.http.dto.MedicalExaminationCreateResponse;
import com.business.group.examination.domain.service.MedicalExaminationService;
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
