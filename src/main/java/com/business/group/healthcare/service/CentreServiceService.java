package com.business.group.healthcare.service;

import com.business.group.healthcare.dao.CentreServiceDAO;
import com.business.group.healthcare.dto.CentreServiceCreateRequest;
import com.business.group.healthcare.dto.CentreServiceCreateResponse;
import com.business.group.healthcare.dto.RoomServiceGetResponse;
import com.business.group.healthcare.mapper.CentreServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CentreServiceService {
    private final CentreServiceDAO centreServiceDAO;
    private final CentreServiceMapper centreServiceMapper;

    public CentreServiceCreateResponse create(CentreServiceCreateRequest dto) {
        return centreServiceMapper.toResponse(centreServiceDAO.save(centreServiceMapper.toEntity(dto)));
    }

    public RoomServiceGetResponse getByMedicalCareIdAndRoomId(long medicalCareId, long roomId) {
        return centreServiceMapper.toRoomServiceGetResponse(centreServiceDAO
                .findByMedicalCareIdAndRoomId(medicalCareId, roomId)
                .orElseThrow());
    }
}
