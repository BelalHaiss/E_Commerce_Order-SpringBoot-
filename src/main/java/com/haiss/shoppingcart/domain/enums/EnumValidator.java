package com.haiss.shoppingcart.domain.enums;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidatorConstraint.class)
public @interface EnumValidator {

    Class<? extends Enum<?>> enumClass();

    String message() default "must be a valid enum ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}


