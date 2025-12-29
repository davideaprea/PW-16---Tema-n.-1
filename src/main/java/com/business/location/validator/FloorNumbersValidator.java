package com.business.location.validator;

import com.business.location.annotation.Contiguous;
import com.business.location.dto.request.MedicalCentreCreateRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class FloorNumbersValidator implements ConstraintValidator<Contiguous, List<MedicalCentreCreateRequest.FloorDTO>> {
    @Override
    public boolean isValid(List<MedicalCentreCreateRequest.FloorDTO> floors, ConstraintValidatorContext context) {
        if (floors == null || floors.isEmpty()) return true;

        List<Integer> sorted = floors.stream()
                .map(MedicalCentreCreateRequest.FloorDTO::number)
                .sorted()
                .toList();

        for (int i = 1; i < sorted.size(); i++) {
            if(sorted.get(i) - sorted.get(i - 1) != 1) {
                return false;
            }
        }

        return true;
    }
}
