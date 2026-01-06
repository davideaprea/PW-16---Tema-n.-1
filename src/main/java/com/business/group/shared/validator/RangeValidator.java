package com.business.group.shared.validator;

import com.business.group.schedule.dto.Range;
import com.business.group.shared.annotation.ValidRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class RangeValidator<T extends Comparable<? super T>> implements ConstraintValidator<ValidRange, Range<T>> {
    @Override
    public boolean isValid(Range<T> value, ConstraintValidatorContext context) {
        if (value == null) return true;

        return value.from().compareTo(value.to()) > 0;
    }
}
