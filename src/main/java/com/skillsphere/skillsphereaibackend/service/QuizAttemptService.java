package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.dto.QuizAttemptRequest;
import com.skillsphere.skillsphereaibackend.entity.Quiz;
import com.skillsphere.skillsphereaibackend.entity.QuizAttempt;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.QuizAttemptRepository;
import com.skillsphere.skillsphereaibackend.repository.QuizRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizAttemptService {

    @Autowired
    private QuizAttemptRepository quizAttemptRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    public QuizAttempt submitQuiz(QuizAttemptRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Quiz not found"));

        QuizAttempt attempt = new QuizAttempt();

        attempt.setUser(user);
        attempt.setQuiz(quiz);
        attempt.setScore(request.getScore());
        attempt.setAttemptDate(LocalDateTime.now());

        return quizAttemptRepository.save(attempt);
    }

    public List<QuizAttempt> getAllAttempts() {
        return quizAttemptRepository.findAll();
    }

    public QuizAttempt getAttempt(Long id) {
        return quizAttemptRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Quiz Attempt not found"));
    }

    public void deleteAttempt(Long id) {
        quizAttemptRepository.delete(getAttempt(id));
    }
}