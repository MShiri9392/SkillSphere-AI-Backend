package com.skillsphere.skillsphereaibackend.repository;

import com.skillsphere.skillsphereaibackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContainingIgnoreCase(String title);

    List<Course> findByInstructorContainingIgnoreCase(String instructor);

    List<Course> findByCategoryContainingIgnoreCase(String category);

    List<Course> findByPriceLessThanEqual(Double price);

    List<Course> findByPriceBetween(Double minPrice, Double maxPrice);

}