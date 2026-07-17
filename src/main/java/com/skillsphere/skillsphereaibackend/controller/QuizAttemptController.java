package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.QuizAttempt;
import com.skillsphere.skillsphereaibackend.service.QuizAttemptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-attempts")
@CrossOrigin("*")
public class QuizAttemptController {

    @Autowired
    private QuizAttemptService quizAttemptService;

    // Student attempts a quiz
    @PostMapping("/{quizId}/{userId}")
    public QuizAttempt attemptQuiz(
            @PathVariable Long quizId,
            @PathVariable Long userId,
            @Valid @RequestBody QuizAttempt attempt) {

        return quizAttemptService.attemptQuiz(quizId, userId, attempt);
    }

    // Get all quiz attempts
    @GetMapping
    public List<QuizAttempt> getAllAttempts() {
        return quizAttemptService.getAllAttempts();
    }

    // Get quiz attempt by ID
    @GetMapping("/{id}")
    public QuizAttempt getAttemptById(@PathVariable Long id) {
        return quizAttemptService.getAttemptById(id);
    }

    // Delete quiz attempt
    @DeleteMapping("/{id}")
    public String deleteAttempt(@PathVariable Long id) {

        quizAttemptService.deleteAttempt(id);

        return "Quiz Attempt Deleted Successfully";
    }
}