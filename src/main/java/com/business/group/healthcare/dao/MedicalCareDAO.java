package com.business.group.healthcare.dao;

import com.business.group.healthcare.entity.MedicalCare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalCareDAO extends JpaRepository<MedicalCare, Long> {
    List<MedicalCare> findAllByDepartmentId(long departmentId);
}
