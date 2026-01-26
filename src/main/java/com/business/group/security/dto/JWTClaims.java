package com.business.group.security.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record JWTClaims(
        String subject,
        Collection<? extends GrantedAuthority> roles
) {
}
