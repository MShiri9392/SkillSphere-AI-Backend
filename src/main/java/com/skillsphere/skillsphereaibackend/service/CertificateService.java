package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Certificate;
import com.skillsphere.skillsphereaibackend.entity.Enrollment;
import com.skillsphere.skillsphereaibackend.entity.Progress;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.CertificateRepository;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import com.skillsphere.skillsphereaibackend.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private ProgressRepository progressRepository;

    public Certificate generateCertificate(Long enrollmentId) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Enrollment not found"));

        Progress progress = progressRepository.findAll()
                .stream()
                .filter(p -> p.getEnrollment().getId().equals(enrollmentId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Progress not found"));

        if (progress.getPercentage() < 100) {
            throw new RuntimeException("Course is not completed yet.");
        }

        Certificate certificate = new Certificate();

        certificate.setEnrollment(enrollment);
        certificate.setCertificateNumber(UUID.randomUUID().toString());
        certificate.setIssueDate(LocalDate.now());

        return certificateRepository.save(certificate);
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Certificate getCertificate(Long id) {
        return certificateRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Certificate not found"));
    }

    public void deleteCertificate(Long id) {
        Certificate certificate = getCertificate(id);
        certificateRepository.delete(certificate);
    }
}