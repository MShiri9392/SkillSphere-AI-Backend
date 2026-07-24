package com.skillsphere.skillsphereaibackend.repository;

import com.skillsphere.skillsphereaibackend.entity.Certificate;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Certificate c WHERE c.enrollment.id = :enrollmentId")
    void deleteCertificateByEnrollmentId(Long enrollmentId);
}