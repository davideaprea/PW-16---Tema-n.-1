package com.business.location.service;

import com.business.location.dao.MedicalCentreDAO;
import com.business.location.dto.request.MedicalCentreCreateRequest;
import com.business.location.entity.MedicalCentre;
import com.business.location.mapper.MedicalCentreMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicalCentreService {
    private final MedicalCentreDAO medicalCentreDAO;
    private final MedicalCentreMapper medicalCentreMapper;

    public MedicalCentre create(MedicalCentreCreateRequest dto) {
        MedicalCentre medicalCentre = medicalCentreMapper.toMedicalCentre(dto);

        return medicalCentreDAO.save(medicalCentre);
    }
}
