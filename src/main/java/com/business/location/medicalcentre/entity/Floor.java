package com.business.location.medicalcentre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(
        name = "medical_centre_floors",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_medical_centre_floor",
                        columnNames = {"medical_centre_id", "number"}
                )
        }
)
@AllArgsConstructor
@Immutable
@NoArgsConstructor
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedicalCentre medicalCentre;

    @Column(nullable = false)
    private Integer number;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "floor",
            orphanRemoval = true
    )
    private List<Room> rooms;

    public void setMedicalCentre(MedicalCentre medicalCentre) {
        if (id == null && this.medicalCentre == null) {
            this.medicalCentre = medicalCentre;
        }
    }

    public Iterator<Room> getRoomsIterator() {
        if (rooms == null) rooms = new ArrayList<>();

        return rooms.iterator();
    }
}
