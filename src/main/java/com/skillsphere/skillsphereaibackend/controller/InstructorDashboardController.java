package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.dto.InstructorDashboardResponse;
import com.skillsphere.skillsphereaibackend.service.InstructorDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructor/dashboard")
@CrossOrigin("*")
public class InstructorDashboardController {

    @Autowired
    private InstructorDashboardService instructorDashboardService;

    @GetMapping
    public InstructorDashboardResponse getDashboard() {
        return instructorDashboardService.getDashboard();
    }
}