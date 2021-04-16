package com.springboot.validator.springbootvalidator.pojo;

import org.springframework.validation.ValidationUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomPaymentValidator implements ConstraintValidator<PaymentValidator, Payment> {

    @Override
    public boolean isValid(Payment payment, ConstraintValidatorContext constraintValidatorContext) {
        if (payment.getPaymentId().equalsIgnoreCase("sample"))
            return false;
        else
            return true;

    }
}
