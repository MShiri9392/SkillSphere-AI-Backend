package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.dto.DashboardResponse;
import com.skillsphere.skillsphereaibackend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public DashboardResponse getDashboard() {
        return dashboardService.getDashboardDetails();
    }
}