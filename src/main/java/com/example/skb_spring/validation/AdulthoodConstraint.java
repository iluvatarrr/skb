package com.example.skb_spring.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = AdulthoodValidator.class)
@Documented
public @interface AdulthoodConstraint {

    String message() default "Adulthood.invalid: Your age less then 18";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
