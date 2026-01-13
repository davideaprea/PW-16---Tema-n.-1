package com.business.group.profile.dao;

import com.business.group.profile.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDAO extends JpaRepository<Patient, Long> {
}
