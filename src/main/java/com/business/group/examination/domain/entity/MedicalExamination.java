package com.business.group.examination.domain.entity;

import com.business.group.examination.domain.enumeration.MedicalExaminationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medical_examinations")
public class MedicalExamination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private Long patientId;

    @Column(nullable = false)
    private LocalDateTime expectedStartTime;

    @Column(nullable = false)
    private LocalDateTime estimatedEndTime;

    @Column(nullable = false)
    private Long medicalCareId;

    @Column(nullable = false)
    private Long medicTimeSlotId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MedicalExaminationStatus status;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private MedicalExaminationReport report;
}
