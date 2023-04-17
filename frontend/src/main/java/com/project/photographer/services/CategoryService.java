package com.project.photographer.services;

import com.project.photographer.models.Category;
import com.project.photographer.models.Pic;
import com.project.photographer.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    public Category findCategory(Long id){
        return categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id: {" + id + "}"));
    }
    public Category createCategory(Category createdData){
        Category categoryToCreate = new Category();
        categoryToCreate.setType(createdData.getType());
        return categoryRepo.save(categoryToCreate);
    }

    public Category updateCategory(Category updatedData, Long id){
        Category categoryToUpdate = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id: {" + id + "}"));
        categoryToUpdate.setType(updatedData.getType());
        return categoryRepo.save(categoryToUpdate);
    }

    public void deleteCategory(Long id){
        Category picToDelete = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id: {" + id + "}"));
        categoryRepo.delete(picToDelete);
    }
}
