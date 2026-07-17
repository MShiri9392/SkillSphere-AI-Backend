package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Enrollment;
import com.skillsphere.skillsphereaibackend.entity.Progress;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import com.skillsphere.skillsphereaibackend.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Progress saveProgress(Long enrollmentId, Progress progress) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Enrollment not found"));

        progress.setEnrollment(enrollment);

        return progressRepository.save(progress);
    }

    public List<Progress> getAllProgress() {
        return progressRepository.findAll();
    }

    public Progress getProgress(Long id) {
        return progressRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Progress not found"));
    }

    public Progress updateProgress(Long id, Progress progress) {

        Progress existing = getProgress(id);

        existing.setPercentage(progress.getPercentage());
        existing.setStatus(progress.getStatus());

        return progressRepository.save(existing);
    }

    public void deleteProgress(Long id) {
        Progress progress = getProgress(id);
        progressRepository.delete(progress);
    }
}