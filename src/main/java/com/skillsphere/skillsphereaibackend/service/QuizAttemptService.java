package com.skillsphere.skillsphereaibackend.service;

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
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    // Student attempts a quiz
    public QuizAttempt attemptQuiz(Long quizId, Long userId, QuizAttempt attempt) {

        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        attempt.setQuiz(quiz);
        attempt.setUser(user);
        attempt.setAttemptedAt(LocalDateTime.now());

        // Auto-calculate score
        if (quiz.getCorrectAnswer().equalsIgnoreCase(attempt.getSelectedAnswer())) {
            attempt.setScore(100);
        } else {
            attempt.setScore(0);
        }

        return quizAttemptRepository.save(attempt);
    }

    // Get all quiz attempts
    public List<QuizAttempt> getAllAttempts() {
        return quizAttemptRepository.findAll();
    }

    // Get attempt by ID
    public QuizAttempt getAttemptById(Long id) {
        return quizAttemptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz attempt not found"));
    }

    // Delete attempt
    public void deleteAttempt(Long id) {
        QuizAttempt attempt = getAttemptById(id);
        quizAttemptRepository.delete(attempt);
    }
}