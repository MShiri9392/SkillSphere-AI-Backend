package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.dto.ReportResponse;
import com.skillsphere.skillsphereaibackend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ReportResponse getReport() {
        return reportService.getReport();
    }
}