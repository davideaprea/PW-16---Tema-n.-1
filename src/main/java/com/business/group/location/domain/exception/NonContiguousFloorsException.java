package com.business.group.location.domain.exception;

import com.business.group.location.http.request.MedicalCentreCreateRequest;
import com.business.group.shared.exception.InvalidParamError;
import com.business.group.shared.exception.InvalidParamsException;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;

@Getter
public class NonContiguousFloorsException extends InvalidParamsException {
    public NonContiguousFloorsException(MedicalCentreCreateRequest.FloorDTO... invalidFloors) {
        super(Arrays.stream(invalidFloors).map(f -> new InvalidParamError(
                Set.of(MedicalCentreCreateRequest.FloorDTO.Fields.number),
                "Non contiguous floor",
                f
        )).toList());
    }
}
