package com.business.group.profile.domain.service;

import com.business.group.profile.dao.MedicDAO;
import com.business.group.profile.domain.dto.MedicDTO;
import com.business.group.profile.domain.mapper.MedicMapper;
import com.business.group.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@AllArgsConstructor
@Service
public class MedicService {
    private final MedicDAO medicDAO;
    private final MedicMapper medicMapper;

    public MedicDTO getById(long id) {
        return medicMapper.toDTO(medicDAO
                .findByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException(Map.of("id", id))));
    }
}
