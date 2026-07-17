package com.skillsphere.skillsphereaibackend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Column(unique = true)
    private String certificateNumber;

    private LocalDate issueDate;

    public Certificate() {
    }

    public Certificate(Long id, Enrollment enrollment, String certificateNumber, LocalDate issueDate) {
        this.id = id;
        this.enrollment = enrollment;
        this.certificateNumber = certificateNumber;
        this.issueDate = issueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
}