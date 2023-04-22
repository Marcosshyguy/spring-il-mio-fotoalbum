package com.project.photographer.models;

import com.project.photographer.annotations.ValidFormatImage;
import jakarta.persistence.OneToOne;
import org.springframework.web.multipart.MultipartFile;

public class ImageForm {

 @ValidFormatImage
 private MultipartFile multipartFile;

 @OneToOne
 private Pic pic;


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Pic getPic() {
        return pic;
    }

    public void setPic(Pic pic) {
        this.pic = pic;
    }
}
