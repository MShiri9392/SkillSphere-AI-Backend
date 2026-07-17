package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String sendMail(@RequestParam String to) {

        emailService.sendEmail(
                to,
                "Welcome to SkillSphere",
                "Thank you for joining SkillSphere LMS.");

        return "Email Sent Successfully";
    }
}