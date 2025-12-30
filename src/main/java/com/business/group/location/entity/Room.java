package com.business.group.location.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@Immutable
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Floor floor;

    public void setFloor(Floor floor) {
        if (id == null && this.floor == null) {
            this.floor = floor;
        }
    }

    public void setNumber(int number) {
        if (id == null && this.number == null) {
            this.number = number;
        }
    }
}
