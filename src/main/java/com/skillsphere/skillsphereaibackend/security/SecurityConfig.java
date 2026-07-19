package com.skillsphere.skillsphereaibackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth

                        // =========================
                        // Public APIs
                        // =========================
                                .requestMatchers(
                                        "/",
                                        "/api/users/login",
                                        "/api/users/register",
                                        "/v3/api-docs/**",
                                        "/swagger-ui/**",
                                        "/swagger-ui.html"
                                ).permitAll()

                        // =========================
                        // Course APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/courses/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/courses/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/courses/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/courses/**").hasRole("ADMIN")

                        // =========================
                        // Quiz APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/quizzes/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/quizzes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/quizzes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/quizzes/**").hasRole("ADMIN")

                        // =========================
                        // Quiz Attempt APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/quiz-attempts/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/quiz-attempts/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/api/quiz-attempts/**").hasRole("ADMIN")

                        // =========================
                        // Enrollment APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/enrollments/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/enrollments/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/api/enrollments/**").hasRole("ADMIN")

                        // =========================
                        // Progress APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/progress/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/progress/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/progress/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/progress/**").hasRole("ADMIN")

                        // =========================
                        // Certificate APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/certificates/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/certificates/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/certificates/**").hasRole("ADMIN")

                        // =========================
                        // Assignment APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/assignments/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/assignments/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/assignments/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/assignments/**").hasRole("ADMIN")

                        // =========================
                        // Assignment Submission APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/submissions/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/submissions/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/api/submissions/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/submissions/**").hasRole("ADMIN")

                        // =========================
                        // Course Review APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/reviews/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/reviews/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/api/reviews/**").hasRole("ADMIN")

                        // =========================
                        // File Upload APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/files/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/files/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/api/files/**").hasRole("ADMIN")

                        // =========================
                        // Discussion APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/discussions/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/discussions/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/api/discussions/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/discussions/**").hasRole("ADMIN")

                        // =========================
                        // Notification APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/notifications/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/notifications/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/notifications/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/api/notifications/**").hasRole("ADMIN")

                        // =========================
                        // Announcement APIs
                        // =========================
                        .requestMatchers(HttpMethod.GET, "/api/announcements/**").hasAnyRole("ADMIN", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/api/announcements/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/announcements/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/announcements/**").hasRole("ADMIN")

                                // =========================
// Announcement APIs
// =========================
                                .requestMatchers(HttpMethod.GET, "/api/announcements/**").hasAnyRole("ADMIN", "STUDENT")
                                .requestMatchers(HttpMethod.POST, "/api/announcements/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/announcements/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/announcements/**").hasRole("ADMIN")

// =========================
// Payment APIs
// =========================
                                .requestMatchers(HttpMethod.GET, "/api/payments/**").hasAnyRole("ADMIN", "STUDENT")
                                .requestMatchers(HttpMethod.POST, "/api/payments/**").hasAnyRole("ADMIN", "STUDENT")
                                .requestMatchers(HttpMethod.DELETE, "/api/payments/**").hasRole("ADMIN")

// =========================
// All Other APIs
// =========================
                                // =========================
// Wishlist APIs
// =========================
                                .requestMatchers(HttpMethod.GET, "/api/wishlist/**").hasAnyRole("ADMIN", "STUDENT")
                                .requestMatchers(HttpMethod.POST, "/api/wishlist/**").hasAnyRole("ADMIN", "STUDENT")
                                .requestMatchers(HttpMethod.DELETE, "/api/wishlist/**").hasAnyRole("ADMIN", "STUDENT")
                                // =========================
// Dashboard APIs
// =========================
                                .requestMatchers(HttpMethod.GET, "/api/dashboard/**")
                                .hasRole("ADMIN")
                                // =========================
// Student Dashboard APIs
// =========================
                                .requestMatchers(HttpMethod.GET, "/api/student/dashboard/**")
                                .hasAnyRole("STUDENT", "ADMIN")
                                // =========================
// Instructor Dashboard APIs
// =========================
                                .requestMatchers(HttpMethod.GET, "/api/instructor/dashboard/**")
                                .hasAnyRole("INSTRUCTOR", "ADMIN")
                                // =========================
// Email APIs
// =========================
                                .requestMatchers(HttpMethod.POST, "/api/email/**")
                                .hasRole("ADMIN")
                                // =========================
// Report APIs
// =========================
                                .requestMatchers(HttpMethod.GET, "/api/reports/**")
                                .hasRole("ADMIN")
                                .anyRequest()
                                .authenticated()
                )

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                )

                .httpBasic(httpBasic -> httpBasic.disable());
        return http.build();
    }
}