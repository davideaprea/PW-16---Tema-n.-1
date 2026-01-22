package com.business.group.examination.dao;

import com.business.group.examination.domain.entity.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicalExaminationDAO extends JpaRepository<MedicalExamination, Long> {
    @Query("""
            SELECT m
            FROM MedicalExamination m
            WHERE m.medicTimeSlotId = :medicTimeSlotId AND
                m.expectedStartTime < :to AND
                m.estimatedEndTime > :from
            """)
    List<MedicalExamination> findAllBetweenDateRange(
            long medicTimeSlotId,
            LocalDateTime from,
            LocalDateTime to
    );
}
