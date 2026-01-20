package com.business.group.shared.service;

import com.business.group.shared.dto.AWSKMSProperties;
import com.business.group.shared.dto.AWSS3Properties;
import com.business.group.shared.dto.FileUploadRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
@AllArgsConstructor
public class FileStorageService {
    private final S3Client s3Client;
    private final AWSS3Properties s3properties;
    private final AWSKMSProperties kmsProperties;

    public void upload(FileUploadRequest uploadRequest) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(s3properties.bucketName())
                .key(uploadRequest.name())
                .serverSideEncryption("aws:kms")
                .ssekmsKeyId(kmsProperties.reportsKeyId())
                .build();

        RequestBody requestBody = RequestBody.fromInputStream(
                uploadRequest.content(),
                uploadRequest.size()
        );

        s3Client.putObject(putObjectRequest, requestBody);
    }
}
