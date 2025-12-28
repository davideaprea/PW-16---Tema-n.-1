package com.business.location.medicalcentre.service;

import com.business.location.medicalcentre.dao.MedicalCentreDAO;
import com.business.location.medicalcentre.entity.MedicalCentre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicalCentreService {
    private final MedicalCentreDAO medicalCentreDAO;

    public MedicalCentre create() {

    }
}
