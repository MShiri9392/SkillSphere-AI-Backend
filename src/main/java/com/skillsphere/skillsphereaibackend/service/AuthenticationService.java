package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.AuthenticationRequest;
import com.skillsphere.skillsphereaibackend.dto.AuthenticationResponse;
import com.skillsphere.skillsphereaibackend.dto.RegisterRequest;
import com.skillsphere.skillsphereaibackend.entity.Role;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import com.skillsphere.skillsphereaibackend.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register User
    public AuthenticationResponse register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Default role
        user.setRole(Role.STUDENT);

        repository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return new AuthenticationResponse(token);
    }

    // Login User
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repository.findByEmail(request.getEmail());

        String token = jwtService.generateToken(user.getEmail());

        return new AuthenticationResponse(token);
    }
}