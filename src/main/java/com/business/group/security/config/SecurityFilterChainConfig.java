package com.business.group.security.config;

import com.business.group.security.enumeration.Roles;
import com.business.group.shared.enumeration.Routes;
import com.business.group.security.filter.UserAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
public class SecurityFilterChainConfig {
    @Bean
    public SecurityFilterChain configFilterChain(HttpSecurity http, UserAuthenticationFilter userAuthenticationFilter) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(reqMatcher -> reqMatcher
                        .requestMatchers(Routes.Auth.BASE + Routes.Auth.REGISTER).permitAll()
                        .requestMatchers(Routes.Auth.BASE + Routes.Auth.LOGIN).permitAll()
                        .requestMatchers(Routes.Regions.BASE).permitAll()
                        .requestMatchers(Routes.MedicalCentres.BASE).permitAll()
                        .requestMatchers(POST, Routes.MedicalCentres.BASE).hasRole(Roles.ADMIN.toString())
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}