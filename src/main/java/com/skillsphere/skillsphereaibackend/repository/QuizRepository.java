package com.skillsphere.skillsphereaibackend.repository;

import com.skillsphere.skillsphereaibackend.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCourseId(Long courseId);

}