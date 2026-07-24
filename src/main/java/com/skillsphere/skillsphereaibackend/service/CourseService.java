package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Add Course
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get Course By ID
    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found with ID: " + id));
    }

    // Update Course
    public Course updateCourse(Long id, Course course) {

        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found with ID: " + id));

        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setInstructor(course.getInstructor());
        existingCourse.setCategory(course.getCategory());
        existingCourse.setPrice(course.getPrice());
        existingCourse.setImageUrl(course.getImageUrl());
        existingCourse.setVideoUrl(course.getVideoUrl());

        return courseRepository.save(existingCourse);
    }

    // Delete Course
    public void deleteCourse(Long id) {

        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found with ID: " + id));

        courseRepository.delete(existingCourse);
    }

    // Search by Title
    public List<Course> searchByTitle(String title) {
        return courseRepository.findByTitleContainingIgnoreCase(title);
    }

    // Search by Instructor
    public List<Course> searchByInstructor(String instructor) {
        return courseRepository.findByInstructorContainingIgnoreCase(instructor);
    }

    // Search by Category
    public List<Course> searchByCategory(String category) {
        return courseRepository.findByCategoryContainingIgnoreCase(category);
    }

    // Filter by Maximum Price
    public List<Course> filterByPrice(Double price) {
        return courseRepository.findByPriceLessThanEqual(price);
    }

    // Filter by Price Range
    public List<Course> filterByPriceRange(Double minPrice, Double maxPrice) {
        return courseRepository.findByPriceBetween(minPrice, maxPrice);
    }
}