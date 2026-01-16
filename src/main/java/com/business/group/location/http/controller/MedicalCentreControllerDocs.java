package com.business.group.location.http.controller;

import com.business.group.location.http.request.MedicalCentreCreateRequest;
import com.business.group.location.http.response.MedicalCentreCreateResponse;
import com.business.group.location.http.response.MedicalCentreGetPageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@Tag(
        name = "Medical centres"
)
public interface MedicalCentreControllerDocs {
    ResponseEntity<MedicalCentreCreateResponse> create(MedicalCentreCreateRequest dto);

    ResponseEntity<Page<MedicalCentreGetPageResponse>> findByRegionAndCity(
            long regionId,
            String city,
            int pageSize,
            int pageNumber
    );
}
