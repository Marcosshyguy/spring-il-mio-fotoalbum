package com.project.photographer.annotations;

import com.project.photographer.validators.ImageFormatValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageFormatValidator.class )
public @interface ValidFormatImage {
    String message() default "Invalid image format. The formats allowed are PNG or JPEG/JPG";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
