package com.business.group.organization.service;

import com.business.group.organization.dao.MedicScheduleDAO;
import com.business.group.organization.dto.MedicScheduleCreateRequest;
import com.business.group.organization.mapper.MedicScheduleMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class MedicScheduleService {
    private MedicScheduleDAO medicScheduleDAO;
    private MedicScheduleMapper medicScheduleMapper;

    public void create(MedicScheduleCreateRequest dto) {
        medicScheduleDAO
                .findAllByRoomId(dto.roomId())
                .forEach(schedule -> {
                    if (dto.overlapsWith(schedule)) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                    }
                });

        medicScheduleDAO.save(medicScheduleMapper.toEntity(dto));
    }
}
