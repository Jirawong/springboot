package com.linksinnovation.springboot.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public class StartWithConstaintValidator implements ConstraintValidator<StartWith, String>{
    
    private String value;

    @Override
    public void initialize(StartWith a) {
        this.value = a.value();
    }

    @Override
    public boolean isValid(String comment, ConstraintValidatorContext cvc) {
        if(comment == null){
            cvc.disableDefaultConstraintViolation();
            cvc
                .buildConstraintViolationWithTemplate("String must start with "+value)
                .addConstraintViolation();
            return false;
        }
        
        return comment.startsWith(value);
    }
    
}
