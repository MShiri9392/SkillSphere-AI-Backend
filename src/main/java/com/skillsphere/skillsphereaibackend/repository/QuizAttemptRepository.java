package com.skillsphere.skillsphereaibackend.repository;

import com.skillsphere.skillsphereaibackend.entity.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
}