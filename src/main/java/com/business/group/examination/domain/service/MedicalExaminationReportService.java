package com.business.group.examination.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

@Service
@AllArgsConstructor
public class MedicalExaminationReportService {


    public void create(String fileName, Path filePath) {
        try {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .serverSideEncryption("aws:kms")   // SSE-KMS
                    .ssekmsKeyId(kmsKeyId)
                    .build();

            s3Client.putObject(request, filePath);
            System.out.println("Referto caricato correttamente su S3");
        } catch (S3Exception e) {
            e.printStackTrace();
        }
    }
}
