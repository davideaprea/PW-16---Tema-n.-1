package com.business.group.shared.configuration;

import com.business.group.shared.dto.AWSClientProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;

@ConfigurationProperties
public class AWSCredentialsProviderConfig {
    @Bean
    public AwsBasicCredentials configCredentialsProvider(AWSClientProperties properties) {
        return AwsBasicCredentials.create(
                properties.accessKey(),
                properties.secretKey()
        );
    }
}
