package com.business.group.schedule.service;

import com.business.group.schedule.dao.MedicScheduleDAO;
import com.business.group.schedule.dto.MedicScheduleCreateRequest;
import com.business.group.schedule.dto.MedicScheduleCreateResponse;
import com.business.group.schedule.entity.MedicSchedule;
import com.business.group.schedule.mapper.MedicScheduleMapper;
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
