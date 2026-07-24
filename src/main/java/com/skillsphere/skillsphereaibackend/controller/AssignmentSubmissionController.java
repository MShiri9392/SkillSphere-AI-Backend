package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.AssignmentSubmission;
import com.skillsphere.skillsphereaibackend.service.AssignmentSubmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@CrossOrigin("*")
public class AssignmentSubmissionController {

    @Autowired
    private AssignmentSubmissionService submissionService;

    @PostMapping("/{assignmentId}/{userId}")
    public AssignmentSubmission submitAssignment(
            @PathVariable Long assignmentId,
            @PathVariable Long userId,
            @Valid @RequestBody AssignmentSubmission submission) {

        return submissionService.submitAssignment(
                assignmentId,
                userId,
                submission
        );
    }

    @GetMapping
    public List<AssignmentSubmission> getAllSubmissions() {

        return submissionService.getAllSubmissions();

    }

    @GetMapping("/{id}")
    public AssignmentSubmission getSubmission(@PathVariable Long id) {

        return submissionService.getSubmission(id);

    }

    // NEW ENDPOINT
    @GetMapping("/student/{userId}")
    public List<AssignmentSubmission> getStudentSubmissions(
            @PathVariable Long userId) {

        return submissionService.getStudentSubmissions(userId);

    }

    @PutMapping("/{id}/grade")
    public AssignmentSubmission gradeSubmission(
            @PathVariable Long id,
            @RequestParam Integer grade,
            @RequestParam String feedback) {

        return submissionService.gradeSubmission(
                id,
                grade,
                feedback
        );
    }

    @DeleteMapping("/{id}")
    public String deleteSubmission(@PathVariable Long id) {

        submissionService.deleteSubmission(id);

        return "Submission Deleted Successfully";
    }

}