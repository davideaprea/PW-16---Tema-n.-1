package com.business.group.healthcare.domain.service;

import com.business.group.healthcare.dao.MedicalCareDAO;
import com.business.group.healthcare.http.dto.MedicalCareGetResponse;
import com.business.group.healthcare.mapper.MedicalCareMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicalCareService {
    private final MedicalCareDAO medicalCareDAO;
    private final MedicalCareMapper medicalCareMapper;

    public List<MedicalCareGetResponse> getByDepartmentId(long departmentId) {
        return medicalCareDAO
                .findAllByDepartmentId(departmentId)
                .stream()
                .map(medicalCareMapper::toResponse)
                .toList();
    }
}
