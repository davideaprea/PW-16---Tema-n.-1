package com.business.group.shared.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aws.credentials")
public record AWSClientProperties(
        String accessKey,
        String secretKey
) {
}
