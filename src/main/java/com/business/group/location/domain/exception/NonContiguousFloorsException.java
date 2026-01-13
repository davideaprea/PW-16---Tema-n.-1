package com.business.group.location.domain.exception;

import com.business.group.location.http.request.MedicalCentreCreateRequest;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class NonContiguousFloorsException extends RuntimeException {
    private final List<MedicalCentreCreateRequest.FloorDTO> invalidFloors;

    public NonContiguousFloorsException(MedicalCentreCreateRequest.FloorDTO... invalidFloors) {
        this(Arrays.asList(invalidFloors));
    }

    public NonContiguousFloorsException(List<MedicalCentreCreateRequest.FloorDTO> invalidFloors) {
        super("Found floors with a non contiguous sequence: %s".formatted(invalidFloors));
        this.invalidFloors = List.copyOf(invalidFloors);
    }
}
