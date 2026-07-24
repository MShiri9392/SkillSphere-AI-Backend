package com.skillsphere.skillsphereaibackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course title is required")
    private String title;

    @NotBlank(message = "Description is required")
    @Column(length = 2000)
    private String description;

    @NotBlank(message = "Instructor name is required")
    private String instructor;


    private String category;

    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;

    private String imageUrl;

    private String videoUrl;

    // Default Constructor
    public Course() {
    }

    // Parameterized Constructor
    public Course(Long id,
                  String title,
                  String description,
                  String instructor,
                  String category,
                  Double price,
                  String imageUrl,
                  String videoUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.category = category;
        this.price = price;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}