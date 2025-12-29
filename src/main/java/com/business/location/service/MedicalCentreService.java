package com.business.location.service;

import com.business.location.dao.MedicalCentreDAO;
import com.business.location.dto.request.MedicalCentreCreateRequest;
import com.business.location.dto.response.MedicalCentreCreateResponse;
import com.business.location.entity.MedicalCentre;
import com.business.location.mapper.MedicalCentreRequestMapper;
import com.business.location.mapper.MedicalCentreResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class MedicalCentreService {
    private final MedicalCentreDAO medicalCentreDAO;
    private final MedicalCentreRequestMapper medicalCentreRequestMapper;
    private final MedicalCentreResponseMapper medicalCentreResponseMapper;

    public MedicalCentreCreateResponse create(MedicalCentreCreateRequest dto) {
        MedicalCentre medicalCentreToSave = medicalCentreRequestMapper.toMedicalCentre(dto);
        MedicalCentre savedMedicalCentre = medicalCentreDAO.save(medicalCentreToSave);

        return medicalCentreDAO
                .findByIdWithRelations(savedMedicalCentre.getId())
                .map(medicalCentreResponseMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
