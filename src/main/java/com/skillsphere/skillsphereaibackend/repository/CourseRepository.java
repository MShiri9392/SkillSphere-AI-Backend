package com.skillsphere.skillsphereaibackend.repository;

import com.skillsphere.skillsphereaibackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContainingIgnoreCase(String title);

    List<Course> findByInstructorContainingIgnoreCase(String instructor);

    List<Course> findByPriceLessThanEqual(Double price);

    List<Course> findByPriceBetween(Double minPrice, Double maxPrice);
}