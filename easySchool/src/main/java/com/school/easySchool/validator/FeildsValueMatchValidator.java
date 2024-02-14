package com.school.easySchool.validator;

import jakarta.validation.ConstraintValidator;
import com.school.easySchool.customAnnotations.feildValueMatch;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;


public class FeildsValueMatchValidator implements ConstraintValidator<feildValueMatch,Object>
{
    private String feild;
    private String feildName;

/*
intialize String field values with interface feildValueMatch
 */
    @Override
    public void initialize(feildValueMatch constraintAnnotation) {
       this.feild = constraintAnnotation.feild();
       this.feildName = constraintAnnotation.feildMatch();
    }
/*
considering the whole object instead of specific fields
 */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        Object feildValue = new BeanWrapperImpl(o).getPropertyValue(feild);
        Object feildValueMatch = new BeanWrapperImpl(o).getPropertyValue(feildName);
    if(feildValue!=null)
    {
        return feildValue.equals(feildValueMatch);
    }
    else {
        return feildValueMatch == null;
    }
    }
}
