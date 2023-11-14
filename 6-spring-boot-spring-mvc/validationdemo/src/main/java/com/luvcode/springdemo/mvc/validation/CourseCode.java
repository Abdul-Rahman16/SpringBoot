package com.luvcode.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy= CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define course code
    public String value() default "HITLER";

    //define default error message
    public String message() default "must start with hitler";

    //default groups
    public Class<?>[] groups() default {};

    //default payloads
    public Class<? extends Payload>[] payload() default {};
}
