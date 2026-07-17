package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Quiz;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    // Add Quiz
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Get All Quizzes
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Get Quiz By ID
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Quiz not found with id : " + id));
    }

    // Update Quiz
    public Quiz updateQuiz(Long id, Quiz quiz) {

        Quiz existingQuiz = getQuiz(id);

        existingQuiz.setTitle(quiz.getTitle());
        existingQuiz.setQuestion(quiz.getQuestion());
        existingQuiz.setOption1(quiz.getOption1());
        existingQuiz.setOption2(quiz.getOption2());
        existingQuiz.setOption3(quiz.getOption3());
        existingQuiz.setOption4(quiz.getOption4());
        existingQuiz.setCorrectAnswer(quiz.getCorrectAnswer());

        return quizRepository.save(existingQuiz);
    }

    // Delete Quiz
    public void deleteQuiz(Long id) {
        Quiz quiz = getQuiz(id);
        quizRepository.delete(quiz);
    }
}