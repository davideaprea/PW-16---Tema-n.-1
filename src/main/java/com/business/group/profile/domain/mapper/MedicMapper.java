package com.business.group.profile.domain.mapper;

import com.business.group.profile.domain.dto.MedicDTO;
import com.business.group.profile.domain.entity.Medic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicMapper {
    MedicDTO toDTO(Medic medic);
}
