package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.DashboardDTO;
import com.skillsphere.skillsphereaibackend.repository.*;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final AssignmentRepository assignmentRepository;
    private final CertificateRepository certificateRepository;
    private final CourseReviewRepository courseReviewRepository;
    private final DiscussionRepository discussionRepository;

    public DashboardService(
            UserRepository userRepository,
            CourseRepository courseRepository,
            EnrollmentRepository enrollmentRepository,
            AssignmentRepository assignmentRepository,
            CertificateRepository certificateRepository,
            CourseReviewRepository courseReviewRepository,
            DiscussionRepository discussionRepository) {

        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.assignmentRepository = assignmentRepository;
        this.certificateRepository = certificateRepository;
        this.courseReviewRepository = courseReviewRepository;
        this.discussionRepository = discussionRepository;
    }

    public DashboardDTO getDashboardStats() {

        return new DashboardDTO(
                userRepository.count(),
                courseRepository.count(),
                enrollmentRepository.count(),
                assignmentRepository.count(),
                certificateRepository.count(),
                courseReviewRepository.count(),
                discussionRepository.count()
        );
    }
}