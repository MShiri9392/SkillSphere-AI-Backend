package com.skillsphere.skillsphereaibackend.dto;

public class DashboardDTO {

    private long totalUsers;
    private long totalCourses;
    private long totalEnrollments;
    private long totalAssignments;
    private long totalCertificates;
    private long totalReviews;
    private long totalDiscussions;

    public DashboardDTO() {}

    public DashboardDTO(long totalUsers,
                        long totalCourses,
                        long totalEnrollments,
                        long totalAssignments,
                        long totalCertificates,
                        long totalReviews,
                        long totalDiscussions) {

        this.totalUsers = totalUsers;
        this.totalCourses = totalCourses;
        this.totalEnrollments = totalEnrollments;
        this.totalAssignments = totalAssignments;
        this.totalCertificates = totalCertificates;
        this.totalReviews = totalReviews;
        this.totalDiscussions = totalDiscussions;
    }

    public long getTotalUsers() { return totalUsers; }
    public void setTotalUsers(long totalUsers) { this.totalUsers = totalUsers; }

    public long getTotalCourses() { return totalCourses; }
    public void setTotalCourses(long totalCourses) { this.totalCourses = totalCourses; }

    public long getTotalEnrollments() { return totalEnrollments; }
    public void setTotalEnrollments(long totalEnrollments) { this.totalEnrollments = totalEnrollments; }

    public long getTotalAssignments() { return totalAssignments; }
    public void setTotalAssignments(long totalAssignments) { this.totalAssignments = totalAssignments; }

    public long getTotalCertificates() { return totalCertificates; }
    public void setTotalCertificates(long totalCertificates) { this.totalCertificates = totalCertificates; }

    public long getTotalReviews() { return totalReviews; }
    public void setTotalReviews(long totalReviews) { this.totalReviews = totalReviews; }

    public long getTotalDiscussions() { return totalDiscussions; }
    public void setTotalDiscussions(long totalDiscussions) { this.totalDiscussions = totalDiscussions; }
}