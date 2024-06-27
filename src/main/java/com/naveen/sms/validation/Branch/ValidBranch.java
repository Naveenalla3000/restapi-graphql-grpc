package com.naveen.sms.validation.Branch;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BranchValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBranch {
    String locale() default "";
    String message() default "Invalid branch";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
