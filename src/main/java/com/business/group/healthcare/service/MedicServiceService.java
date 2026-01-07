package com.business.group.healthcare.service;

import com.business.group.healthcare.dao.MedicServiceDAO;
import com.business.group.healthcare.dto.MedicServiceCreateRequest;
import com.business.group.healthcare.dto.MedicServiceCreateResponse;
import com.business.group.healthcare.mapper.MedicServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicServiceService {
    private final MedicServiceDAO medicServiceDAO;
    private final MedicServiceMapper medicServiceMapper;

    public MedicServiceCreateResponse create(MedicServiceCreateRequest createRequest) {
        return medicServiceMapper.toResponse(medicServiceDAO.save(medicServiceMapper.toEntity(createRequest)));
    }
}
