package com.project.photographer.repositories;

import com.project.photographer.models.Pic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PicRepo extends JpaRepository<Pic, Long> {
    List<Pic> findByTitleContainingIgnoreCase(String keyword);
}
