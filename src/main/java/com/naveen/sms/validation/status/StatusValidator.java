package com.naveen.sms.validation.status;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class StatusValidator implements ConstraintValidator<ValidStatus,String> {
    private final List<String> validStatus =Arrays.asList(
            "ACTIVE", "SUSPENDED", "GRADUATED"
    );
    @Override
    public void initialize(ValidStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && validStatus.contains(s.toUpperCase());
    }
}
