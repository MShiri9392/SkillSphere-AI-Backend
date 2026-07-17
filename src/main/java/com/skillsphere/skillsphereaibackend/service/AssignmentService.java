package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Assignment;
import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.AssignmentRepository;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Assignment addAssignment(Long courseId, Assignment assignment) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found"));

        assignment.setCourse(course);

        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignment(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assignment not found"));
    }

    public Assignment updateAssignment(Long id, Assignment assignment) {

        Assignment existing = getAssignment(id);

        existing.setTitle(assignment.getTitle());
        existing.setDescription(assignment.getDescription());

        return assignmentRepository.save(existing);
    }

    public void deleteAssignment(Long id) {
        Assignment assignment = getAssignment(id);
        assignmentRepository.delete(assignment);
    }
}