package com.business.group.healthcare.dao;

import com.business.group.healthcare.domain.entity.MedicQualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicQualificationDAO extends JpaRepository<MedicQualification, Long> {
}
