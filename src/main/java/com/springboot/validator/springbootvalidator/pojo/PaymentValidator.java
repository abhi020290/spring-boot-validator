package com.springboot.validator.springbootvalidator.pojo;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = CustomPaymentValidator.class
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PaymentValidator {
    String message() default "{javax.validation.constraints.PaymentValidator.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
