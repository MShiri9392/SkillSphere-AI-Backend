package com.skillsphere.skillsphereaibackend.dto;

public class ReportResponse {

    private long users;
    private long courses;
    private long enrollments;
    private long quizzes;
    private long payments;

    public ReportResponse() {
    }

    public long getUsers() {
        return users;
    }

    public void setUsers(long users) {
        this.users = users;
    }

    public long getCourses() {
        return courses;
    }

    public void setCourses(long courses) {
        this.courses = courses;
    }

    public long getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(long enrollments) {
        this.enrollments = enrollments;
    }

    public long getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(long quizzes) {
        this.quizzes = quizzes;
    }

    public long getPayments() {
        return payments;
    }

    public void setPayments(long payments) {
        this.payments = payments;
    }
}