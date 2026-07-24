package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Quiz;
import com.skillsphere.skillsphereaibackend.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:5173")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return service.addQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> getAll() {
        return service.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        return service.getQuizById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Quiz> getByCourse(@PathVariable Long courseId) {
        return service.getCourseQuizzes(courseId);
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable Long id,
                       @RequestBody Quiz quiz) {
        return service.updateQuiz(id, quiz);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteQuiz(id);
    }

}