package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testRegisterUser() {

        User user = new User();
        user.setName("Shiri");
        user.setEmail("shiri@gmail.com");
        user.setPassword("12345");

        when(userRepository.save(user)).thenReturn(user);

        User saved = userService.register(user);

        assertEquals("Shiri", saved.getName());
        assertEquals("shiri@gmail.com", saved.getEmail());
        assertEquals("12345", saved.getPassword());
    }

    @Test
    void testLoginUser() {

        User user = new User();
        user.setName("Shiri");
        user.setEmail("shiri@gmail.com");
        user.setPassword("12345");

        when(userRepository.findByEmail("shiri@gmail.com")).thenReturn(user);

        User loggedUser = userService.login("shiri@gmail.com");

        assertEquals("Shiri", loggedUser.getName());
        assertEquals("shiri@gmail.com", loggedUser.getEmail());
    }
}