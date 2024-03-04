package com.example.form.CustomAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Constraint(validatedBy = DateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface DateValidation {
    String message() default " !! To Date should not be less than From Date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
