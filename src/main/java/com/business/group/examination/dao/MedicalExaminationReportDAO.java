package com.business.group.examination.dao;

import com.business.group.examination.domain.entity.MedicalExaminationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationReportDAO extends JpaRepository<MedicalExaminationReport, Long> {
}
