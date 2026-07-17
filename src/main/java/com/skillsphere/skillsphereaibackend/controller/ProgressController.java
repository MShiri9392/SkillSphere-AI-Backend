package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Progress;
import com.skillsphere.skillsphereaibackend.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin("*")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/{enrollmentId}")
    public Progress addProgress(@PathVariable Long enrollmentId,
                                @Valid @RequestBody Progress progress) {

        return progressService.saveProgress(enrollmentId, progress);
    }

    @GetMapping
    public List<Progress> getAllProgress() {
        return progressService.getAllProgress();
    }

    @GetMapping("/{id}")
    public Progress getProgress(@PathVariable Long id) {
        return progressService.getProgress(id);
    }

    @PutMapping("/{id}")
    public Progress updateProgress(@PathVariable Long id,
                                   @Valid @RequestBody Progress progress) {
        return progressService.updateProgress(id, progress);
    }

    @DeleteMapping("/{id}")
    public String deleteProgress(@PathVariable Long id) {
        progressService.deleteProgress(id);
        return "Progress Deleted Successfully";
    }
}