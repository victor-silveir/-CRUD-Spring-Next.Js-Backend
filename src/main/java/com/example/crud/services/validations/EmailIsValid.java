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
@Constraint(validatedBy = EmailValidation.class)
@Documented
public @interface EmailIsValid {
    String message() default "E-mail inválido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
