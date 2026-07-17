package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Assignment;
import com.skillsphere.skillsphereaibackend.service.AssignmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin("*")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // Add Assignment
    @PostMapping("/{courseId}")
    public Assignment addAssignment(@PathVariable Long courseId,
                                    @Valid @RequestBody Assignment assignment) {
        return assignmentService.addAssignment(courseId, assignment);
    }

    // Get All Assignments
    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    // Get Assignment By ID
    @GetMapping("/{id}")
    public Assignment getAssignment(@PathVariable Long id) {
        return assignmentService.getAssignment(id);
    }

    // Update Assignment
    @PutMapping("/{id}")
    public Assignment updateAssignment(@PathVariable Long id,
                                       @Valid @RequestBody Assignment assignment) {
        return assignmentService.updateAssignment(id, assignment);
    }

    // Delete Assignment
    @DeleteMapping("/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return "Assignment Deleted Successfully";
    }
}
