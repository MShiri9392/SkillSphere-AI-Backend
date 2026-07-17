package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.InstructorDashboardResponse;
import com.skillsphere.skillsphereaibackend.repository.AssignmentRepository;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import com.skillsphere.skillsphereaibackend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorDashboardService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public InstructorDashboardResponse getDashboard() {

        InstructorDashboardResponse response = new InstructorDashboardResponse();

        response.setTotalCourses(courseRepository.count());
        response.setTotalQuizzes(quizRepository.count());
        response.setTotalAssignments(assignmentRepository.count());
        response.setTotalEnrollments(enrollmentRepository.count());

        return response;
    }
}