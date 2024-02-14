package com.school.easySchool.customAnnotations;

import com.school.easySchool.validator.FeildsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FeildsValueMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface feildValueMatch {
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload()  default{};

    String message() default  "Feild values dont match";

    String feild();
    String feildMatch();
/*
Values will be passed to list in the run time when
the user enter the values. those values will be inserted into these list
 */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List
    {
        feildValueMatch[] value();
    }

}
