package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Quiz;
import com.skillsphere.skillsphereaibackend.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public Quiz addQuiz(Quiz quiz) {
        return repository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return repository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Quiz not found with id : " + id));
    }

    public List<Quiz> getCourseQuizzes(Long courseId) {
        return repository.findByCourseId(courseId);
    }

    public Quiz updateQuiz(Long id, Quiz quiz) {

        Quiz existing = getQuizById(id);

        existing.setTitle(quiz.getTitle());
        existing.setQuestion(quiz.getQuestion());
        existing.setOptionA(quiz.getOptionA());
        existing.setOptionB(quiz.getOptionB());
        existing.setOptionC(quiz.getOptionC());
        existing.setOptionD(quiz.getOptionD());
        existing.setCorrectAnswer(quiz.getCorrectAnswer());
        existing.setCourseId(quiz.getCourseId());

        return repository.save(existing);
    }

    public void deleteQuiz(Long id) {
        repository.deleteById(id);
    }

}