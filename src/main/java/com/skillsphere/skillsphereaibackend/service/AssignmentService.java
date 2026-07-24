package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Assignment;
import com.skillsphere.skillsphereaibackend.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository repository;

    public AssignmentService(AssignmentRepository repository) {
        this.repository = repository;
    }

    public Assignment addAssignment(Assignment assignment) {
        return repository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return repository.findAll();
    }

    public Assignment getAssignment(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Assignment updateAssignment(Long id, Assignment assignment) {

        Assignment existing = getAssignment(id);

        existing.setTitle(assignment.getTitle());
        existing.setDescription(assignment.getDescription());
        existing.setDueDate(assignment.getDueDate());
        existing.setCourseId(assignment.getCourseId());

        return repository.save(existing);
    }

    public void deleteAssignment(Long id) {
        repository.deleteById(id);
    }
}