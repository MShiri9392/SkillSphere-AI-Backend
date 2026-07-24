package com.skillsphere.skillsphereaibackend.repository;

import com.skillsphere.skillsphereaibackend.entity.Progress;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Progress p WHERE p.enrollment.id = :enrollmentId")
    void deleteProgressByEnrollmentId(Long enrollmentId);
}