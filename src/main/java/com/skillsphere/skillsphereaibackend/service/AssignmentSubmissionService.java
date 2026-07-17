package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Assignment;
import com.skillsphere.skillsphereaibackend.entity.AssignmentSubmission;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.AssignmentRepository;
import com.skillsphere.skillsphereaibackend.repository.AssignmentSubmissionRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentSubmissionService {

    @Autowired
    private AssignmentSubmissionRepository submissionRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private UserRepository userRepository;

    public AssignmentSubmission submitAssignment(Long assignmentId,
                                                 Long userId,
                                                 AssignmentSubmission submission) {

        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assignment not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        submission.setAssignment(assignment);
        submission.setUser(user);
        submission.setSubmittedAt(LocalDateTime.now());

        return submissionRepository.save(submission);
    }

    public List<AssignmentSubmission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public AssignmentSubmission getSubmission(Long id) {
        return submissionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Submission not found"));
    }

    public AssignmentSubmission gradeSubmission(Long id,
                                                Integer grade,
                                                String feedback) {

        AssignmentSubmission submission = getSubmission(id);

        submission.setGrade(grade);
        submission.setFeedback(feedback);

        return submissionRepository.save(submission);
    }

    public void deleteSubmission(Long id) {

        AssignmentSubmission submission = getSubmission(id);

        submissionRepository.delete(submission);
    }
}