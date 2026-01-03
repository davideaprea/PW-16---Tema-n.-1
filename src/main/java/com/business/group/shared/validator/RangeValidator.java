package com.business.group.shared.validator;

import com.business.group.shared.annotation.ValidRange;
import com.business.group.shared.time.Range;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class RangeValidator implements ConstraintValidator<ValidRange, Range> {
    @Override
    public boolean isValid(Range value, ConstraintValidatorContext context) {
        if (value == null) return true;

        return value.isValid();
    }
}
