package com.business.location.medicalcentre.validator;

import com.business.location.medicalcentre.annotation.Contiguous;
import com.business.location.medicalcentre.dto.FloorDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class FloorNumbersValidator implements ConstraintValidator<Contiguous, List<FloorDTO>> {
    @Override
    public boolean isValid(List<FloorDTO> floors, ConstraintValidatorContext context) {
        if (floors == null || floors.isEmpty()) return true;

        List<Long> sorted = floors.stream()
                .map(FloorDTO::number)
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
