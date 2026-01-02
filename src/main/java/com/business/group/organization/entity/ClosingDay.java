package com.business.group.organization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "centre_closing_days")
@NoArgsConstructor
@Getter
@Setter
public class ClosingDay {
    private Long id;

    private LocalDate date;

    private String cause;
}
