package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Assignment;
import com.skillsphere.skillsphereaibackend.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "http://localhost:5173")
public class AssignmentController {

    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public Assignment addAssignment(@RequestBody Assignment assignment) {
        return service.addAssignment(assignment);
    }

    @GetMapping
    public List<Assignment> getAll() {
        return service.getAllAssignments();
    }

    @GetMapping("/{id}")
    public Assignment getAssignment(@PathVariable Long id) {
        return service.getAssignment(id);
    }

    @PutMapping("/{id}")
    public Assignment update(@PathVariable Long id,
                             @RequestBody Assignment assignment) {
        return service.updateAssignment(id, assignment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAssignment(id);
    }
}