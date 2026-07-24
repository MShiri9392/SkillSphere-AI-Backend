package com.skillsphere.skillsphereaibackend.dto;

import jakarta.validation.constraints.NotNull;

public class QuizAttemptRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long quizId;

    @NotNull
    private Integer score;

    public QuizAttemptRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}