package com.business.group.shared.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Optional;

@ConfigurationProperties(prefix = "aws.s3")
public record AWSS3Properties(
        String region,
        String bucketName,
        Optional<String> endpoint
) {
}
