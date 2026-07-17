package com.skillsphere.skillsphereaibackend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("========== JWT FILTER CALLED ==========");
        System.out.println("Request URI : " + request.getRequestURI());

        final String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization Header : " + authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("No Bearer Token Found");
            filterChain.doFilter(request, response);
            return;
        }

        try {

            final String jwt = authHeader.substring(7);
            System.out.println("JWT Token : " + jwt);

            final String email = jwtService.extractUsername(jwt);
            System.out.println("Email From Token : " + email);

            if (email != null &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails =
                        userDetailsService.loadUserByUsername(email);

                System.out.println("User Loaded : " + userDetails.getUsername());

                if (jwtService.isTokenValid(jwt, userDetails.getUsername())) {

                    System.out.println("Token Valid");

                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    authToken.setDetails(
                            new WebAuthenticationDetailsSource()
                                    .buildDetails(request)
                    );

                    SecurityContextHolder.getContext()
                            .setAuthentication(authToken);

                    System.out.println("Authentication Set Successfully");
                } else {
                    System.out.println("Invalid Token");
                }
            }

        } catch (Exception e) {

            System.out.println("JWT ERROR");

            e.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }
}