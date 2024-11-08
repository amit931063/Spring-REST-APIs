package com.amit.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
@Constraint(validatedBy={EmployeeRoleValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})

public  @interface EmployeeRoleValidation {
    String message() default " Role of  employee should be  either USER OR ADMIN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
