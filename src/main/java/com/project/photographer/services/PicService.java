package com.project.photographer.services;

import com.project.photographer.models.Pic;
import com.project.photographer.repositories.PicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicService {
    @Autowired
    PicRepo picRepo;

    public List<Pic> getAllPics(){
        return picRepo.findAll();
    }

    public List<Pic> getFilteredPics(String keyword) {
        return picRepo.findByTitleContainingIgnoreCase(keyword);
    }
}
