package com.business.group.profile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medics")
@NoArgsConstructor
@Getter
@Setter
public class Medic extends Profile {
    @Column(length = 500)
    private String biography;

    @Column(nullable = false, unique = true)
    private String licenseNumber;
}
