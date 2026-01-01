package com.business.group.profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operators")
@NoArgsConstructor
@Getter
@Setter
public class Operator extends Profile {
}
