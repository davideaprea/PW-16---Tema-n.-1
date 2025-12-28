package com.business.location.service;

import com.business.location.dao.MedicalCentreDAO;
import com.business.location.dto.MedicalCentreDTO;
import com.business.location.entity.MedicalCentre;
import com.business.location.mapper.MedicalCentreMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicalCentreService {
    private final MedicalCentreDAO medicalCentreDAO;
    private final MedicalCentreMapper medicalCentreMapper;

    public MedicalCentre create(MedicalCentreDTO dto) {
        MedicalCentre medicalCentre = medicalCentreMapper.toMedicalCentre(dto);

        return medicalCentreDAO.save(medicalCentre);
    }
}
