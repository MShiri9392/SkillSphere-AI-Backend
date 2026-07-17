package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Quiz;
import com.skillsphere.skillsphereaibackend.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Add Quiz
    @PostMapping
    public Quiz addQuiz(@Valid @RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    // Get All Quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    // Get Quiz By ID
    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        return quizService.getQuiz(id);
    }

    // Update Quiz
    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id,
                           @Valid @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    // Delete Quiz
    @DeleteMapping("/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return "Quiz Deleted Successfully";
    }
}