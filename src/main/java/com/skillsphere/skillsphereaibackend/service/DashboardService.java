package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.DashboardResponse;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import com.skillsphere.skillsphereaibackend.repository.PaymentRepository;
import com.skillsphere.skillsphereaibackend.repository.QuizRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

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

    public DashboardResponse getDashboardDetails() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalUsers(userRepository.count());
        response.setTotalCourses(courseRepository.count());
        response.setTotalEnrollments(enrollmentRepository.count());
        response.setTotalQuizzes(quizRepository.count());
        response.setTotalPayments(paymentRepository.count());

        return response;
    }
}