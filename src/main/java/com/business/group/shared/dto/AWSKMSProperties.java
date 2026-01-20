package com.business.group.shared.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Optional;

@ConfigurationProperties("aws.kms")
public record AWSKMSProperties(
        String region,
        Optional<String> endpoint,
        String reportsKeyId
) {
}
