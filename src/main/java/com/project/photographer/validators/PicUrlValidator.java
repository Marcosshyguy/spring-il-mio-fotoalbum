package com.project.photographer.validators;

import com.project.photographer.annotations.ValidPicUrl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class PicUrlValidator implements ConstraintValidator<ValidPicUrl, String> {
    @Override
    public void initialize(ValidPicUrl constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        try {
            URL imageUrl = new URL(url);

            // Si apre la connessione
            URLConnection connection = imageUrl.openConnection();
            String contentType = connection.getContentType();
            if (contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png"))) {
                // Carica l'immagine e verifica che sia valida
                BufferedImage image = ImageIO.read(connection.getInputStream());
                if (image != null) {
                    return true; // L'URL è valido ed è un'immagine PNG o JPEG
                }
            }
        } catch (IOException e) {
            // Gestisci l'eccezione
        }
        return false; // L'URL non è valido o non è un'immagine PNG o JPEG
    }
}
