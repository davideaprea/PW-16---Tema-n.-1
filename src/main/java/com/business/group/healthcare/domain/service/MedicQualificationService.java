package com.business.group.healthcare.domain.service;

import com.business.group.healthcare.dao.MedicQualificationDAO;
import com.business.group.healthcare.http.dto.MedicQualificationCreateRequest;
import com.business.group.healthcare.http.dto.MedicQualificationCreateResponse;
import com.business.group.healthcare.mapper.MedicQualificationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicQualificationService {
    private final MedicQualificationDAO medicQualificationDAO;
    private final MedicQualificationMapper medicQualificationMapper;

    public MedicQualificationCreateResponse create(MedicQualificationCreateRequest createRequest) {
        return medicQualificationMapper.toResponse(medicQualificationDAO.save(medicQualificationMapper.toEntity(createRequest)));
    }
}
