package com.business.group.healthcare.mapper;

import com.business.group.healthcare.dto.DepartmentGetResponse;
import com.business.group.healthcare.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MedicalServiceMapper.class)
public interface DepartmentMapper {
    DepartmentGetResponse toResponse(Department department);
}
