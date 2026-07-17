package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.entity.Enrollment;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.EnrollmentRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment enroll(Long userId, Long courseId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found"));

        Enrollment enrollment = new Enrollment();

        enrollment.setUser(user);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public void deleteEnrollment(Long id) {

        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Enrollment not found"));

        enrollmentRepository.delete(enrollment);
    }
}