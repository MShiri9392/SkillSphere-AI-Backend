package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.ReportResponse;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import com.skillsphere.skillsphereaibackend.repository.PaymentRepository;
import com.skillsphere.skillsphereaibackend.repository.QuizRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public ReportResponse getReport() {

        ReportResponse response = new ReportResponse();

        response.setUsers(userRepository.count());
        response.setCourses(courseRepository.count());
        response.setEnrollments(enrollmentRepository.count());
        response.setQuizzes(quizRepository.count());
        response.setPayments(paymentRepository.count());

        return response;
    }
}