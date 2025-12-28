package com.business.location.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(
        name = "medical_centre_floor_rooms",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_floor_room",
                        columnNames = {"floor_id", "number"}
                )
        }
)
@AllArgsConstructor
@Getter
@Immutable
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Floor floor;
}
