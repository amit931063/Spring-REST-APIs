package com.amit.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String > {

    @Override
    public boolean isValid(String inputemployee, ConstraintValidatorContext constraintValidatorContext) {
        if(inputemployee==null) return false;
        List<String>roles= List.of("ADMIN","USER");
       return   roles.contains(inputemployee);
    }


}
