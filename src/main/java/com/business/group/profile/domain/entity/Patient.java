package com.business.group.profile.domain.entity;

import com.business.group.profile.domain.enumeration.Gender;
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

    @Column(nullable = false, unique = true, length = 16)
    private String taxIdCode;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
