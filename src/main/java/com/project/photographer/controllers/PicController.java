package com.project.photographer.controllers;

import com.project.photographer.models.Pic;
import com.project.photographer.services.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PicController {
    @Autowired
    PicService picService;

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
}
