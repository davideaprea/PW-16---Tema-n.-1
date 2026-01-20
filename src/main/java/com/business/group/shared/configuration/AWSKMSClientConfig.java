package com.business.group.shared.configuration;

import com.business.group.shared.dto.AWSKMSProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.KmsClientBuilder;

import java.net.URI;

@Configuration
public class AWSKMSClientConfig {
    @Bean
    public KmsClient kmsClient(
            AwsBasicCredentials credentials,
            AWSKMSProperties properties
    ) {
        KmsClientBuilder builder = KmsClient.builder()
                .region(Region.of(properties.region()))
                .credentialsProvider(StaticCredentialsProvider.create(credentials));

        properties.endpoint().ifPresent(endpoint -> {
            builder.endpointOverride(URI.create(endpoint));
        });

        return builder.build();
    }
}
