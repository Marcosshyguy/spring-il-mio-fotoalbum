package com.project.photographer.services;

import com.project.photographer.models.Category;
import com.project.photographer.models.Image;
import com.project.photographer.models.ImageForm;
import com.project.photographer.models.Pic;
import com.project.photographer.repositories.CategoryRepo;
import com.project.photographer.repositories.ImageRepo;
import com.project.photographer.repositories.PicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PicService {
    @Autowired
    PicRepo picRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ImageRepo imageRepo;


    public List<Pic> getAllPics(){
        return picRepo.findAll();
    }

    public List<Pic> getFilteredPics(String keyword) {
        return picRepo.findByTitleContainingIgnoreCase(keyword);
    }

    public Optional<Pic> findPic(Long id){
        return picRepo.findById(id);
    }

    public Pic createPic(Pic createdData, ImageForm imageForm) throws IOException {
        Pic picToCreate = new Pic();
        Set<Category> categories = new HashSet<>();
        picToCreate.setTitle(createdData.getTitle());
        picToCreate.setDescription(createdData.getDescription());
        picToCreate.setUrl(createdData.getUrl());
        picToCreate.setVisible(createdData.getVisible());
        if(imageForm != null){
            picToCreate.setCover(createCover(imageForm));
        }


        if (createdData.getCategories() != null) {
            for (Category c : createdData.getCategories()) {
                categories.add(categoryRepo.findById(c.getId()).orElseThrow());
            }
        }
         picToCreate.setCategories(categories);

         return picRepo.save(picToCreate);

    }

    public Pic updatePic(Pic updatedData, Long id, ImageForm imageForm) throws IOException {
        Set<Category> categories = new HashSet<>();
        Pic picToUpdate = picRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid photo Id: {" + id + "}"));
        picToUpdate.setTitle(updatedData.getTitle());
        picToUpdate.setDescription(updatedData.getDescription());
        picToUpdate.setUrl(updatedData.getUrl());
        picToUpdate.setVisible(updatedData.getVisible());

        if(imageForm != null){
            picToUpdate.setCover(createCover(imageForm));
        }

        if (updatedData.getCategories() != null) {
            for (Category c : updatedData.getCategories()) {
                categories.add(categoryRepo.findById(c.getId()).orElseThrow());
            }
        }
        picToUpdate.setCategories(categories);

        return picRepo.save(picToUpdate);
    }

    public void deletePic(Long id){
        Pic picToDelete = picRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid photo Id: {" + id + "}"));
        picRepo.delete(picToDelete);
    }

    public Image createCover(ImageForm imageForm) throws IOException {
        Image newImage = new Image();
        newImage.setContent(imageForm.getMultipartFile().getBytes());
        return  newImage;
    }
}
