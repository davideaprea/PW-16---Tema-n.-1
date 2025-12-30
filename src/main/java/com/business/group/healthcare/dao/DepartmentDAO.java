package com.business.group.healthcare.dao;

import com.business.group.healthcare.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDAO extends JpaRepository<Department, Long> {
}
