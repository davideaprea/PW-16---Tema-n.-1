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
                        .requestMatchers("/swagger/**").permitAll()
                        .requestMatchers(Routes.Auth.BASE + Routes.Auth.REGISTER).permitAll()
                        .requestMatchers(Routes.Auth.BASE + Routes.Auth.LOGIN).permitAll()
                        .requestMatchers(GET, Routes.Regions.BASE).permitAll()
                        .requestMatchers(Routes.MedicalCentres.BASE).hasRole(Roles.ADMIN.toString())
                        .requestMatchers(GET, Routes.MedicalCentres.BASE).permitAll()
                        .requestMatchers(Routes.MedicalCentresCalendars.BASE).hasRole(Roles.ADMIN.toString())
                        .requestMatchers(Routes.MedicSchedules.BASE).hasRole(Roles.ADMIN.toString())
                        .requestMatchers(Routes.Bookings.BASE).hasAnyRole(Roles.ADMIN.toString(), Roles.OPERATOR.toString())
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}