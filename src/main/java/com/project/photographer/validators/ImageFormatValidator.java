package com.project.photographer.validators;

import com.project.photographer.annotations.ValidFormatImage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class ImageFormatValidator implements ConstraintValidator<ValidFormatImage, MultipartFile> {

    @Override
    public void initialize(ValidFormatImage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        return imageContentFormat(multipartFile.getContentType());
    }

    // Controllo del MIME type a rispettivo ritorno di bbooleano se vine rispettato il formato o se è null
    private boolean imageContentFormat(String contentType){
        if (Objects.equals(contentType, "application/octet-stream")) {
            return true;
        }
        String[] contentFormatSplit = contentType.split("/");
        return contentFormatSplit[0].equalsIgnoreCase("image") && (contentFormatSplit[1].equalsIgnoreCase("jpeg") || contentFormatSplit[1].equalsIgnoreCase("png"));
    }
}
