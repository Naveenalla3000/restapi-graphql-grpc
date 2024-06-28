package com.naveen.sms.validation.Branch;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class BranchValidator implements ConstraintValidator<ValidBranch, String> {
    private final List<String> validBranches = Arrays.asList(
            "CSE-H",
            "CSE-R",
            "AIDS",
            "IOT",
            "ECE",
            "MUSIC",
            "DANCE",
            "NURSING",
            "MARKETING",
            "FINANCE",
            "SURGERY",
            "FINANCE",
            "CHEMISTRY",
            "LITERATURE",
            "MECHANICAL",
            "BIOLOGY",
            "CIVIL",
            "ECONOMICS",
            "MATHEMATICS",
            "HISTORY"
    );

    @Override
    public void initialize(ValidBranch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && validBranches.contains(value.toUpperCase());
    }
}
