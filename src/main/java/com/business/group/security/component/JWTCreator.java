package com.business.group.security.component;

import com.business.group.security.dto.JWTConfigProps;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@Component
public class JWTCreator {
    private final JWTConfigProps jwtConfigProps;

    public String withSubject(final String subject) {
        Date expDate = new Date(new Date().getTime() + jwtConfigProps.expTime());

        return Jwts
                .builder()
                .subject(subject)
                .expiration(expDate)
                .signWith(jwtConfigProps.key())
                .compact();
    }
}
