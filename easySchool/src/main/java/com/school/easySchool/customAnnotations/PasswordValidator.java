package com.school.easySchool.customAnnotations;


import com.school.easySchool.validator.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator
{
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "please choose a strong password";
}
