package com.skillsphere.skillsphereaibackend.dto;

public class LoginResponse {

    private Long id;
    private String token;
    private String role;
    private String email;
    private String name;

    public LoginResponse() {
    }

    public LoginResponse(Long id, String token, String role, String email, String name) {
        this.id = id;
        this.token = token;
        this.role = role;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}