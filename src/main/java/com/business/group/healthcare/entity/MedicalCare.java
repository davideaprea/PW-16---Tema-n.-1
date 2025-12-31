package com.business.group.healthcare.entity;

import com.business.group.shared.converter.DurationConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "medical_care")
public class MedicalCare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department department;

    @Convert(converter = DurationConverter.class)
    @Column(nullable = false, name = "duration_in_seconds")
    private Duration duration;
}
