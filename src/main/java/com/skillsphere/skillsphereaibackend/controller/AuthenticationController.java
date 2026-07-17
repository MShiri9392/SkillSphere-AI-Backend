package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.dto.AuthenticationRequest;
import com.skillsphere.skillsphereaibackend.dto.AuthenticationResponse;
import com.skillsphere.skillsphereaibackend.dto.RegisterRequest;
import com.skillsphere.skillsphereaibackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {

        System.out.println("========== Register API Called ==========");

        AuthenticationResponse response = service.register(request);

        System.out.println("========== User Registered Successfully ==========");

        return response;
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {

        System.out.println("========== Login API Called ==========");

        AuthenticationResponse response = service.authenticate(request);

        System.out.println("========== Login Successful ==========");

        return response;
    }
}