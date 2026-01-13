package com.business.group.location.domain.service;

import com.business.group.location.dao.MedicalCentreDAO;
import com.business.group.location.http.request.MedicalCentreCreateRequest;
import com.business.group.location.http.response.MedicalCentreCreateResponse;
import com.business.group.location.http.response.MedicalCentreGetPageResponse;
import com.business.group.location.domain.entity.MedicalCentre;
import com.business.group.location.mapper.MedicalCentreRequestMapper;
import com.business.group.location.mapper.MedicalCentreResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class MedicalCentreService {
    private final MedicalCentreDAO medicalCentreDAO;
    private final MedicalCentreRequestMapper medicalCentreRequestMapper;
    private final MedicalCentreResponseMapper medicalCentreResponseMapper;

    @Transactional
    public MedicalCentreCreateResponse create(MedicalCentreCreateRequest dto) {
        MedicalCentre medicalCentreToSave = medicalCentreRequestMapper.toMedicalCentre(dto);
        MedicalCentre savedMedicalCentre = medicalCentreDAO.save(medicalCentreToSave);

        return medicalCentreDAO
                .findByIdWithRelations(savedMedicalCentre.getId())
                .map(medicalCentreResponseMapper::toResponse)
                .orElseThrow(() -> new IllegalStateException(
                        "MedicalCentre %d was just saved but cannot be found with relations"
                                .formatted(savedMedicalCentre.getId())
                ));
    }

    public Page<MedicalCentreGetPageResponse> findByRegionAndCity(
            long regionId,
            String cityName,
            Pageable pageable
    ) {
        return medicalCentreDAO
                .findByRegionAndCity(regionId, cityName, pageable)
                .map(medicalCentreResponseMapper::toPageResponse);
    }
}
