package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.StudentDashboardResponse;
import com.skillsphere.skillsphereaibackend.repository.AssignmentRepository;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import com.skillsphere.skillsphereaibackend.repository.PaymentRepository;
import com.skillsphere.skillsphereaibackend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDashboardService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public StudentDashboardResponse getDashboard() {

        StudentDashboardResponse response = new StudentDashboardResponse();

        response.setTotalEnrollments(enrollmentRepository.count());
        response.setTotalQuizzes(quizRepository.count());
        response.setTotalAssignments(assignmentRepository.count());
        response.setTotalPayments(paymentRepository.count());

        return response;
    }
}