package com.business.group.examination.http.controller;

import com.business.group.examination.domain.dto.ExaminationDTO;
import com.business.group.examination.http.dto.MedicalExaminationCreateRequest;
import com.business.group.examination.http.dto.MedicalExaminationCreateResponse;
import com.business.group.examination.domain.service.MedicalExaminationService;
import com.business.group.security.dto.AuthUserDetails;
import com.business.group.shared.enumeration.Routes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.MedicalExaminations.BASE)
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

    @GetMapping("/medics")
    public ResponseEntity<List<ExaminationDTO>> findAllByMedicId(
            @AuthenticationPrincipal AuthUserDetails userDetails
    ) {
        return ResponseEntity.ok(medicalExaminationService.findAllByMedicId(userDetails.getId()));
    }
}
