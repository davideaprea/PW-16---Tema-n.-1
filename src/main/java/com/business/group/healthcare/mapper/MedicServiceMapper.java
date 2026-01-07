package com.business.group.healthcare.mapper;

import com.business.group.healthcare.dto.MedicServiceCreateRequest;
import com.business.group.healthcare.dto.MedicServiceCreateResponse;
import com.business.group.healthcare.entity.MedicService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicServiceMapper {
    MedicService toEntity(MedicServiceCreateRequest dto);

    MedicServiceCreateResponse toResponse(MedicService medicService);
}
