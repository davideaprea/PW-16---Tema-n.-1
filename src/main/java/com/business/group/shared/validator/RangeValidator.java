package com.business.group.shared.validator;

import com.business.group.shared.annotation.ValidRange;
import com.business.group.shared.time.TimeRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class RangeValidator implements ConstraintValidator<ValidRange, TimeRange> {
    @Override
    public boolean isValid(TimeRange value, ConstraintValidatorContext context) {
        if (value == null) return true;

        return value.isValid();
    }
}
