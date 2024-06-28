package com.naveen.sms.validation.Department;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DepartmentValidator.class)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.TYPE_USE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDepartment {
    String locale() default "";
    String message() default "Invalid department";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
