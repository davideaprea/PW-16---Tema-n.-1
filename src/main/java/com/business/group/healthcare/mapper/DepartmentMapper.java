package com.business.group.healthcare.mapper;

import com.business.group.healthcare.http.dto.DepartmentGetResponse;
import com.business.group.healthcare.domain.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MedicalCareMapper.class)
public interface DepartmentMapper {
    DepartmentGetResponse toResponse(Department department);
}
