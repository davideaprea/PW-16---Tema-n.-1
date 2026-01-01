package com.business.group.profile.entity;

import com.business.group.profile.enumeration.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Getter
@Setter
public class Patient extends Profile {
    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String taxIdCode;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Gender gender;
}
