package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.CourseReview;
import com.skillsphere.skillsphereaibackend.service.CourseReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class CourseReviewController {

    @Autowired
    private CourseReviewService reviewService;

    // Add Review
    @PostMapping("/{courseId}/{userId}")
    public CourseReview addReview(
            @PathVariable Long courseId,
            @PathVariable Long userId,
            @Valid @RequestBody CourseReview review) {

        return reviewService.addReview(courseId, userId, review);
    }

    // Get All Reviews
    @GetMapping
    public List<CourseReview> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Get Review By ID
    @GetMapping("/{id}")
    public CourseReview getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    // Delete Review
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully";
    }
}