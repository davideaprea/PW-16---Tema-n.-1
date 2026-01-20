package com.business.group.examination.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_examination_reports")
public class MedicalExaminationReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentLink;
}
