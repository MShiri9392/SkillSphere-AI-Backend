package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.dto.QuizAttemptRequest;
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

    @PostMapping
    public QuizAttempt submitQuiz(@Valid @RequestBody QuizAttemptRequest request) {
        return quizAttemptService.submitQuiz(request);
    }

    @GetMapping
    public List<QuizAttempt> getAllAttempts() {
        return quizAttemptService.getAllAttempts();
    }

    @GetMapping("/{id}")
    public QuizAttempt getAttempt(@PathVariable Long id) {
        return quizAttemptService.getAttempt(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAttempt(@PathVariable Long id) {
        quizAttemptService.deleteAttempt(id);
        return "Quiz Attempt Deleted Successfully";
    }
}