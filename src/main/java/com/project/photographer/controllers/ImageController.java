package com.project.photographer.controllers;

import com.project.photographer.models.Image;
import com.project.photographer.repositories.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageRepo imageRepo;
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Image image = imageRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));


        //Lettore immagini
        String contentType = null;
        try(ByteArrayInputStream bis = new ByteArrayInputStream(image.getContent())) {
            ImageInputStream iis = ImageIO.createImageInputStream(bis);
            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
            if (imageReaders.hasNext()) {
                ImageReader reader = imageReaders.next();
                contentType = reader.getFormatName().toLowerCase();
            }
        }

        //  Settare il tipo di formato
        MediaType mediaType;
        if ("jpeg".equals(contentType)) {
            mediaType = MediaType.IMAGE_JPEG;
        } else if ("png".equals(contentType)) {
            mediaType = MediaType.IMAGE_PNG;
        } else {
//            default ma non mi fido
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }

        return ResponseEntity.ok().contentType(mediaType).body(image.getContent());
    }
}
