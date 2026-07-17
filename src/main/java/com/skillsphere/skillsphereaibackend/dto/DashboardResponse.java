package com.skillsphere.skillsphereaibackend.dto;

public class DashboardResponse {

    private long totalUsers;
    private long totalCourses;
    private long totalEnrollments;
    private long totalQuizzes;
    private long totalPayments;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalUsers,
                             long totalCourses,
                             long totalEnrollments,
                             long totalQuizzes,
                             long totalPayments) {

        this.totalUsers = totalUsers;
        this.totalCourses = totalCourses;
        this.totalEnrollments = totalEnrollments;
        this.totalQuizzes = totalQuizzes;
        this.totalPayments = totalPayments;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(long totalCourses) {
        this.totalCourses = totalCourses;
    }

    public long getTotalEnrollments() {
        return totalEnrollments;
    }

    public void setTotalEnrollments(long totalEnrollments) {
        this.totalEnrollments = totalEnrollments;
    }

    public long getTotalQuizzes() {
        return totalQuizzes;
    }

    public void setTotalQuizzes(long totalQuizzes) {
        this.totalQuizzes = totalQuizzes;
    }

    public long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(long totalPayments) {
        this.totalPayments = totalPayments;
    }
}