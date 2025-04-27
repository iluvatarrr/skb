package com.example.skb_spring.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Min(1)
@Max(3)
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RUNTIME)
public @interface JunRange {
    String message() default "JunRange must be between 1 and 3";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}