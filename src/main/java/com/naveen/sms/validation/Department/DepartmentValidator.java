package com.naveen.sms.validation.Department;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;


public class DepartmentValidator implements ConstraintValidator<ValidDepartment, String>{
    private final List<String> validDepartments = Arrays.asList(
            "SCIENCE", "ARTS", "COMMERCE", "ENGINEERING", "MEDICAL"
    );
    @Override
    public void initialize(ValidDepartment constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && validDepartments.contains(value.toUpperCase());
    }
}
