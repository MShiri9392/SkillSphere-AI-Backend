package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // =========================
    // Add Course
    // =========================
    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    // =========================
    // Get All Courses
    // =========================
    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    // =========================
    // Get Course By ID
    // =========================
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    // =========================
    // Update Course
    // =========================
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id,
                               @Valid @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    // =========================
    // Delete Course
    // =========================
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course Deleted Successfully";
    }

    // =========================
    // Search Course By Title
    // =========================
    @GetMapping("/search/title")
    public List<Course> searchByTitle(@RequestParam String title) {
        return courseService.searchByTitle(title);
    }

    // =========================
    // Search Course By Instructor
    // =========================
    @GetMapping("/search/instructor")
    public List<Course> searchByInstructor(@RequestParam String instructor) {
        return courseService.searchByInstructor(instructor);
    }
    // =========================
// Search Course By Category
// =========================
    @GetMapping("/search/category")
    public List<Course> searchByCategory(@RequestParam String category) {
        return courseService.searchByCategory(category);
    }

    // =========================
    // Filter Courses By Maximum Price
    // =========================
    @GetMapping("/search/price")
    public List<Course> filterByPrice(@RequestParam Double price) {
        return courseService.filterByPrice(price);
    }

    // =========================
    // Filter Courses By Price Range
    // =========================
    @GetMapping("/search/range")
    public List<Course> filterByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {

        return courseService.filterByPriceRange(minPrice, maxPrice);
    }
}