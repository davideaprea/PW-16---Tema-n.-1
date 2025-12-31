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
                        .requestMatchers(Routes.AUTH + Routes.REGISTER).permitAll()
                        .requestMatchers(Routes.AUTH + Routes.LOGIN).permitAll()
                        .requestMatchers(Routes.REGIONS).permitAll()
                        .requestMatchers(Routes.MEDICAL_CENTRES).permitAll()
                        .requestMatchers(POST, Routes.MEDICAL_CENTRES).hasRole(Roles.ADMIN.toString())
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}