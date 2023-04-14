package com.project.photographer.controllers;

import com.project.photographer.models.Category;
import com.project.photographer.repositories.CategoryRepo;
import com.project.photographer.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String index(Model model, @RequestParam(name = "id") Optional<Long> id){
        model.addAttribute("cats", categoryService.getAllCategory());

        if (id.isEmpty()) {
            model.addAttribute("newCategory", new Category());
        }else{

            try {
                model.addAttribute("categoryToUpdate", categoryService.findCategory(id.get()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return "/categories/index";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("newCategory") Category createdData, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("newCategory", new Category());
            return "categories/index";
        }
        categoryService.createCategory(createdData);
        return "redirect:/categories";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("categoryToUpdate") Category updatedData, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "categories/index";
        }

        try {
            categoryService.updateCategory(updatedData, id);
            return "redirect:/categories";
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id: {" + id + "} not found");
        }

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
         categoryService.deleteCategory(id);

        return "redirect:/categories";
    }
}
