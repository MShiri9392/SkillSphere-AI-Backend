package com.skillsphere.skillsphereaibackend.repository;

import com.skillsphere.skillsphereaibackend.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByUserId(Long userId);

}