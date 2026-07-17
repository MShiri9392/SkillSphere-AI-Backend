package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.dto.StudentDashboardResponse;
import com.skillsphere.skillsphereaibackend.service.StudentDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/dashboard")
@CrossOrigin("*")
public class StudentDashboardController {

    @Autowired
    private StudentDashboardService studentDashboardService;

    @GetMapping
    public StudentDashboardResponse getDashboard() {
        return studentDashboardService.getDashboard();
    }
}