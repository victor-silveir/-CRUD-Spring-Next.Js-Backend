package com.example.crud.services.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailIsNotEmptyValidation.class)
@Documented
public @interface EmailIsNotEmpty {
    String message() default "É necessário preencher pelo o menos 1 E-mail.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
