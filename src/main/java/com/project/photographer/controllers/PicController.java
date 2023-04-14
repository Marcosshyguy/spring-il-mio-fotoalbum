package com.project.photographer.controllers;

import com.project.photographer.models.Pic;
import com.project.photographer.repositories.CategoryRepo;
import com.project.photographer.repositories.PicRepo;
import com.project.photographer.services.CategoryService;
import com.project.photographer.services.PicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PicController {
    @Autowired
    PicService picService;
    @Autowired
    CategoryService categoryService;
//    @Autowired
//    PicRepo picRepo;

    @GetMapping
    public String getPhotos(Model model, @RequestParam(name = "input")Optional<String> keyword){
        List<Pic> pics;

        if (keyword.isPresent()) {
            pics = picService.getFilteredPics(keyword.get());
            model.addAttribute("keyword", keyword.get());
        }else{
            pics = picService.getAllPics();
        }

        model.addAttribute("pics", pics);

        return "/photos/index";
    }

    @GetMapping("/{id}")
    public String showPic(Model model, @PathVariable Long id){
        Optional<Pic> pic = picService.findPic(id);

        if (pic.isPresent()) {
            model.addAttribute("pic", pic.get());
            return "/photos/show";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with id: {" + id + "} not found");
        }
    }

    @GetMapping("/create")
    public String create (Model model){

        model.addAttribute("newPic", new Pic());
        model.addAttribute("categories", categoryService.getAllCategory());

        return "/photos/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("newPic") Pic createdData, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAllCategory());
            return "/photos/create";
        }
        picService.createPic(createdData);
        return "redirect:/photos";
    }

    @GetMapping("/edit/{id}")
    public String edit (Model model, @PathVariable Long id){


        model.addAttribute("picToUpdate", picService.findPic(id).get());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "/photos/edit";
    }

    @PutMapping("/edit/{id}")
    public String update(@PathVariable Long id,@Valid @ModelAttribute("picToUpdate") Pic updatedData, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAllCategory());
            return "/photos/edit";
        }

        try {
            picService.updatePic(updatedData, id);
            return "redirect:/photos";
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with id: {" + id + "} not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public String update(@PathVariable Long id){
        picService.deletePic(id);
        return "redirect:/photos";
    }
}

