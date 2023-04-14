package com.project.photographer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "This field must not be empty")
    @Size(min = 5, max = 20, message = "The type must be between 5 and 20 characters")
    private String type;

    @ManyToMany(mappedBy = "categories")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Pic> pics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Pic> getPics() {
        return pics;
    }
    public void setPics(Set<Pic> pics) {
        this.pics = pics;
    }
}
