package com.naveen.sms.validation.phoneNo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNoValidator implements ConstraintValidator<ValidatePhoneNo, String>{
    @Override
    public void initialize(ValidatePhoneNo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }
}
