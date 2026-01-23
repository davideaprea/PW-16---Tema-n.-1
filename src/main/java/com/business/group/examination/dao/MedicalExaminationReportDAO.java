package com.business.group.examination.dao;

import com.business.group.examination.domain.entity.MedicalExaminationReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MedicalExaminationReportDAO extends JpaRepository<MedicalExaminationReport, Long> {
    @Query("""
            SELECT r
            FROM MedicalExaminationReport r
            JOIN FETCH r.medicalExamination
            WHERE r.id = :id
            """)
    Optional<MedicalExaminationReport> findById(long id);

    @Query("""
            SELECT r
            FROM MedicalExaminationReport r
            JOIN FETCH r.medicalExamination
            WHERE
                r.medicalExamination.patientId = :userId OR
                r.medicalExamination.medicId = :userId
            """)
    List<MedicalExaminationReport> findAllByUserId(long userId);
}
