package com.business.group.healthcare.mapper;

import com.business.group.healthcare.dto.RoomMedicalCareCreateRequest;
import com.business.group.healthcare.dto.RoomMedicalCareCreateResponse;
import com.business.group.healthcare.dto.RoomMedicalCareGetResponse;
import com.business.group.healthcare.entity.RoomMedicalCare;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMedicalCareMapper {
    RoomMedicalCare toEntity(RoomMedicalCareCreateRequest dto);

    RoomMedicalCareCreateResponse toResponse(RoomMedicalCare roomMedicalCare);

    RoomMedicalCareGetResponse toRoomServiceGetResponse(RoomMedicalCare roomMedicalCare);
}
