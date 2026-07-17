package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.entity.CourseReview;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.CourseReviewRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseReviewService {

    @Autowired
    private CourseReviewRepository reviewRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    // Add Review
    public CourseReview addReview(Long courseId, Long userId, CourseReview review) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        review.setCourse(course);
        review.setUser(user);

        return reviewRepository.save(review);
    }

    // Get All Reviews
    public List<CourseReview> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get Review By ID
    public CourseReview getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found"));
    }

    // Delete Review
    public void deleteReview(Long id) {
        CourseReview review = getReviewById(id);
        reviewRepository.delete(review);
    }
}