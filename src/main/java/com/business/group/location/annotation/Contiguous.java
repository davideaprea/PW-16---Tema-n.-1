package com.business.group.location.annotation;

import com.business.group.location.validator.FloorNumbersValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FloorNumbersValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Contiguous {
    String message() default "Floor numbers must be contiguous.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
