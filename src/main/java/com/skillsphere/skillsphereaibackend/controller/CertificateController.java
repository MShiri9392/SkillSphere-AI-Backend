package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Certificate;
import com.skillsphere.skillsphereaibackend.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
@CrossOrigin("*")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("/generate/{enrollmentId}")
    public Certificate generateCertificate(@PathVariable Long enrollmentId) {
        return certificateService.generateCertificate(enrollmentId);
    }

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/{id}")
    public Certificate getCertificate(@PathVariable Long id) {
        return certificateService.getCertificate(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
        return "Certificate Deleted Successfully";
    }
}