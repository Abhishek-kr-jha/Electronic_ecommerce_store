package com.lcwd.electronic.store.validate;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy =  ImageNameValidator.class)
public @interface ImageNameValid {
    // error message
    String message() default "Inavlid Image Name !! ";

    // represent group of constraints
    Class<?>[] groups() default {};
    // additional information about annotation
    Class<? extends jakarta.validation.Payload>[] payload() default {};
}
