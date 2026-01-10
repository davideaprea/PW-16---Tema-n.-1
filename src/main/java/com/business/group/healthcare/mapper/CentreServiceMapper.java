package com.business.group.healthcare.mapper;

import com.business.group.healthcare.dto.CentreServiceCreateRequest;
import com.business.group.healthcare.dto.CentreServiceCreateResponse;
import com.business.group.healthcare.dto.RoomServiceGetResponse;
import com.business.group.healthcare.entity.CentreService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CentreServiceMapper {
    CentreService toEntity(CentreServiceCreateRequest dto);

    CentreServiceCreateResponse toResponse(CentreService centreService);

    RoomServiceGetResponse toRoomServiceGetResponse(CentreService centreService);
}
