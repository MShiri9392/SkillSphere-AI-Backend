package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        System.out.println("REGISTER API CALLED");

        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        System.out.println("LOGIN API CALLED");

        return userService.login(user.getEmail());
    }
}