package com.project.photographer.repositories;

import com.project.photographer.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {

}
