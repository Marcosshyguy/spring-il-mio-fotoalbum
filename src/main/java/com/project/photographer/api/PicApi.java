package com.project.photographer.api;

import com.project.photographer.models.Category;
import com.project.photographer.models.Pic;
import com.project.photographer.repositories.PicRepo;
import com.project.photographer.services.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api/photos")
public class PicApi {
    @Autowired
    private PicService picService;

    @GetMapping
    public List<Pic> getPhotos(@RequestParam(name = "input")Optional<String> keyword){
        List<Pic> pics;

        if (keyword.isPresent()) {
           return pics = picService.getFilteredPics(keyword.get());

        }else{
            return pics = picService.getAllPics();
        }

    }

    @GetMapping("/{id}")
    public Pic showPic(@PathVariable Long id){
        Optional<Pic> pic = picService.findPic(id);
        if (pic.isPresent()) {
            return pic.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo with id: {" + id + "} not found");
        }
    }
}
