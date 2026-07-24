package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.LoginResponse;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import com.skillsphere.skillsphereaibackend.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register User
    public User register(User user) {

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    // Login User
    public LoginResponse login(User loginUser) {

        User user = userRepository.findByEmail(loginUser.getEmail());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(
                user.getId(),
                token,
                user.getRole().name(),
                user.getEmail(),
                user.getName()
        );
    }
}