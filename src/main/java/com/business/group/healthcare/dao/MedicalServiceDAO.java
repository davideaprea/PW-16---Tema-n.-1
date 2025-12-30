package com.business.group.healthcare.dao;

import com.business.group.healthcare.entity.MedicalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalServiceDAO extends JpaRepository<MedicalService, Long> {
}
