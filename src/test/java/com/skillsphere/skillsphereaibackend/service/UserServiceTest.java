package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.LoginResponse;
import com.skillsphere.skillsphereaibackend.entity.Role;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import com.skillsphere.skillsphereaibackend.security.JwtService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void testRegisterUser() {

        User user = new User();
        user.setName("Shiri");
        user.setEmail("shiri@gmail.com");
        user.setPassword("12345");
        user.setRole(Role.STUDENT);

        when(passwordEncoder.encode("12345")).thenReturn("encodedPassword");

        User savedUser = new User();
        savedUser.setName("Shiri");
        savedUser.setEmail("shiri@gmail.com");
        savedUser.setPassword("encodedPassword");
        savedUser.setRole(Role.STUDENT);

        when(userRepository.save(user)).thenReturn(savedUser);

        User saved = userService.register(user);

        assertEquals("Shiri", saved.getName());
        assertEquals("shiri@gmail.com", saved.getEmail());
        assertEquals("encodedPassword", saved.getPassword());
    }

    @Test
    void testLoginUser() {

        User loginUser = new User();
        loginUser.setEmail("shiri@gmail.com");
        loginUser.setPassword("12345");

        User storedUser = new User();
        storedUser.setName("Shiri");
        storedUser.setEmail("shiri@gmail.com");
        storedUser.setPassword("encodedPassword");
        storedUser.setRole(Role.STUDENT);

        when(userRepository.findByEmail("shiri@gmail.com")).thenReturn(storedUser);
        when(passwordEncoder.matches("12345", "encodedPassword")).thenReturn(true);
        when(jwtService.generateToken("shiri@gmail.com")).thenReturn("dummy-jwt-token");

        LoginResponse response = userService.login(loginUser);

        assertEquals("dummy-jwt-token", response.getToken());
        assertEquals(Role.STUDENT.name(), response.getRole());
        assertEquals("shiri@gmail.com", response.getEmail());
        assertEquals("Shiri", response.getName());
    }
}