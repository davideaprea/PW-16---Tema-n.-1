package com.business.group.location.http.controller;

import com.business.group.location.http.response.RegionGetResponse;
import com.business.group.location.domain.service.RegionService;
import com.business.group.shared.enumeration.Routes;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Routes.Regions.BASE)
public class RegionController implements RegionControllerDocs {
    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionGetResponse>> getAll() {
        return ResponseEntity.ok(regionService.getAll());
    }
}
