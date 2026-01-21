package com.business.group.examination.domain.service;

import com.business.group.examination.dao.MedicalExaminationReportDAO;
import com.business.group.examination.domain.dto.MedicalExaminationGetResponse;
import com.business.group.examination.domain.dto.ReportCreateCommand;
import com.business.group.examination.mapper.ReportMapper;
import com.business.group.shared.dto.FileUploadRequest;
import com.business.group.shared.exception.ResourceNotFoundException;
import com.business.group.shared.service.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class MedicalExaminationReportService {
    private final MedicalExaminationReportDAO medicalExaminationReportDAO;
    private final FileStorageService fileStorageService;
    private final MedicalExaminationService medicalExaminationService;
    private final ReportMapper reportMapper;

    @Transactional
    public void create(ReportCreateCommand command) {
        MedicalExaminationGetResponse examination = medicalExaminationService.getById(command.medicalExaminationId());
        String documentLink = "reports/%d".formatted(command.medicalExaminationId());

        if (command.medicId() != examination.medicId()) {
            throw new ResourceNotFoundException(Map.of("medicId", command.medicId()));
        }

        medicalExaminationReportDAO.save(reportMapper.toEntity(documentLink, command.medicalExaminationId()));

        try {
            fileStorageService.upload(new FileUploadRequest(
                    documentLink,
                    command.fileContent().getInputStream(),
                    command.fileContent().getSize()
            ));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
