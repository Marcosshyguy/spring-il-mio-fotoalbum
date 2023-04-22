package com.project.photographer.annotations;

import com.project.photographer.validators.PicUrlValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PicUrlValidator.class)
public @interface ValidPicUrl {
    String message() default "Invalid url format. The formats allowed are PNG or JPEG/JPG";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
