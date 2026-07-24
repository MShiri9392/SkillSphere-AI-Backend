package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Enrollment;
import com.skillsphere.skillsphereaibackend.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "http://localhost:5173")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping
    public Enrollment enroll(@RequestBody Enrollment enrollment) {
        return service.enroll(enrollment);
    }

    @GetMapping
    public List<Enrollment> getAll() {
        return service.getAllEnrollments();
    }

    @GetMapping("/user/{userId}")
    public List<Enrollment> getByUser(@PathVariable Long userId) {
        return service.getUserEnrollments(userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEnrollment(id);
    }
}