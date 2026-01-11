package com.business.group.location.service;

import com.business.group.location.dao.MedicalCentreDAO;
import com.business.group.location.dto.request.MedicalCentreCreateRequest;
import com.business.group.location.dto.response.MedicalCentreCreateResponse;
import com.business.group.location.dto.response.MedicalCentreGetPageResponse;
import com.business.group.location.entity.MedicalCentre;
import com.business.group.location.mapper.MedicalCentreRequestMapper;
import com.business.group.location.mapper.MedicalCentreResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicalCentreService {
    private final MedicalCentreDAO medicalCentreDAO;
    private final MedicalCentreRequestMapper medicalCentreRequestMapper;
    private final MedicalCentreResponseMapper medicalCentreResponseMapper;

    @Transactional
    public MedicalCentreCreateResponse create(MedicalCentreCreateRequest dto) {
        areFloorsContiguous(dto.floors());

        MedicalCentre medicalCentreToSave = medicalCentreRequestMapper.toMedicalCentre(dto);
        MedicalCentre savedMedicalCentre = medicalCentreDAO.save(medicalCentreToSave);

        return medicalCentreDAO
                .findByIdWithRelations(savedMedicalCentre.getId())
                .map(medicalCentreResponseMapper::toResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private void areFloorsContiguous(List<MedicalCentreCreateRequest.FloorDTO> floors) {
        List<Integer> sorted = floors.stream()
                .map(MedicalCentreCreateRequest.FloorDTO::number)
                .sorted()
                .toList();

        for (int i = 1; i < sorted.size(); i++) {
            if(sorted.get(i) - sorted.get(i - 1) != 1) {
                //throw
            }
        }
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
