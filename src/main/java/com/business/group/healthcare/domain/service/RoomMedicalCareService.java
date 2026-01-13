package com.business.group.healthcare.domain.service;

import com.business.group.healthcare.dao.RoomMedicalCareDAO;
import com.business.group.healthcare.http.dto.RoomMedicalCareCreateRequest;
import com.business.group.healthcare.http.dto.RoomMedicalCareCreateResponse;
import com.business.group.healthcare.http.dto.RoomMedicalCareGetResponse;
import com.business.group.healthcare.mapper.RoomMedicalCareMapper;
import com.business.group.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoomMedicalCareService {
    private final RoomMedicalCareDAO roomMedicalCareDAO;
    private final RoomMedicalCareMapper roomMedicalCareMapper;

    public RoomMedicalCareCreateResponse create(RoomMedicalCareCreateRequest dto) {
        return roomMedicalCareMapper.toResponse(roomMedicalCareDAO.save(roomMedicalCareMapper.toEntity(dto)));
    }

    public RoomMedicalCareGetResponse getByMedicalCareIdAndRoomId(long medicalCareId, long roomId) {
        return roomMedicalCareMapper.toRoomServiceGetResponse(roomMedicalCareDAO
                .findByMedicalCareIdAndRoomId(medicalCareId, roomId)
                .orElseThrow(ResourceNotFoundException::new));
    }
}
