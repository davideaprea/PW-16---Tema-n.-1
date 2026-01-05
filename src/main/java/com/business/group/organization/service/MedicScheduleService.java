package com.business.group.organization.service;

import com.business.group.organization.dao.MedicScheduleDAO;
import com.business.group.organization.dto.MedicScheduleCreateRequest;
import com.business.group.organization.dto.MedicScheduleCreateResponse;
import com.business.group.organization.entity.MedicSchedule;
import com.business.group.organization.mapper.MedicScheduleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicScheduleService {
    private MedicScheduleDAO medicScheduleDAO;
    private MedicScheduleMapper medicScheduleMapper;

    public MedicScheduleCreateResponse create(MedicScheduleCreateRequest dto) {
        final boolean isOverlapping = medicScheduleDAO
                .findAllByRoomId(dto.roomId())
                .stream()
                .anyMatch(dto::overlapsWith);

        if (isOverlapping) {
            //throw
        }

        MedicSchedule medicSchedule = medicScheduleDAO.save(medicScheduleMapper.toEntity(dto));

        return medicScheduleMapper.toResponse(medicSchedule);
    }
}
