package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Enrollment;
import com.skillsphere.skillsphereaibackend.repository.CertificateRepository;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import com.skillsphere.skillsphereaibackend.repository.ProgressRepository;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repository;
    private final CertificateRepository certificateRepository;
    private final ProgressRepository progressRepository;
    public EnrollmentService(
            EnrollmentRepository repository,
            CertificateRepository certificateRepository,
            ProgressRepository progressRepository) {

        this.repository = repository;
        this.certificateRepository = certificateRepository;
        this.progressRepository = progressRepository;
    }


    public Enrollment enroll(Enrollment enrollment) {
        enrollment.setStatus("ENROLLED");
        return repository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    public List<Enrollment> getUserEnrollments(Long userId) {
        return repository.findByUserId(userId);
    }
    public void deleteEnrollment(Long id) {

        Enrollment enrollment = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Enrollment not found"));

        // Delete certificate first
        certificateRepository.deleteCertificateByEnrollmentId(id);

        // Delete progress
        progressRepository.deleteProgressByEnrollmentId(id);

        // Delete enrollment
        repository.delete(enrollment);
    }

}