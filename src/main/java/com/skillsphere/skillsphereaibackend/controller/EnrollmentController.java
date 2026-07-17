package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Enrollment;
import com.skillsphere.skillsphereaibackend.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin("*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/{userId}/{courseId}")
    public Enrollment enroll(@PathVariable Long userId,
                             @PathVariable Long courseId) {

        return enrollmentService.enroll(userId, courseId);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {

        enrollmentService.deleteEnrollment(id);

        return "Enrollment Deleted Successfully";
    }
}