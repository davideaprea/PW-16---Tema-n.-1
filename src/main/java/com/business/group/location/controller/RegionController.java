package com.business.group.location.controller;

import com.business.group.location.dto.response.RegionGetResponse;
import com.business.group.location.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionGetResponse>> getAll() {
        return ResponseEntity.ok(regionService.getAll());
    }
}
