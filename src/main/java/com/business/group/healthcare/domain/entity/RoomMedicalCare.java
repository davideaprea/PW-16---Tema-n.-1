package com.business.group.healthcare.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "centres_services",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_medical_care_room_id",
                        columnNames = {"room_id", "medical_care"}
                )
        }
)
public class RoomMedicalCare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicalCare medicalCare;

    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private BigDecimal price;
}
