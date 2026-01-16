package com.business.group.location.http.controller;

import com.business.group.location.http.request.MedicalCentreCreateRequest;
import com.business.group.location.http.response.MedicalCentreCreateResponse;
import com.business.group.location.http.response.MedicalCentreGetPageResponse;
import com.business.group.shared.http.doc.ResourceCreatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface MedicalCentreControllerDocs {
    @ResourceCreatedResponse(MedicalCentreCreateResponse.class)
    ResponseEntity<MedicalCentreCreateResponse> create(MedicalCentreCreateRequest dto);

    ResponseEntity<Page<MedicalCentreGetPageResponse>> findByRegionAndCity(
            long regionId,
            String city,
            int pageSize,
            int pageNumber
    );
}
