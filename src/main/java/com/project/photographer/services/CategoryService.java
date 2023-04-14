package com.project.photographer.services;

import com.project.photographer.models.Category;
import com.project.photographer.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

}
