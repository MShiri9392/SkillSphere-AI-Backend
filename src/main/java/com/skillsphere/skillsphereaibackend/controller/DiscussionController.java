package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Discussion;
import com.skillsphere.skillsphereaibackend.service.DiscussionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discussions")
@CrossOrigin("*")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    // Student/Admin creates discussion
    @PostMapping("/{courseId}/{userId}")
    public Discussion createDiscussion(
            @PathVariable Long courseId,
            @PathVariable Long userId,
            @Valid @RequestBody Discussion discussion) {

        return discussionService.createDiscussion(courseId, userId, discussion);
    }

    // Get all discussions
    @GetMapping
    public List<Discussion> getAllDiscussions() {
        return discussionService.getAllDiscussions();
    }

    // Get discussion by ID
    @GetMapping("/{id}")
    public Discussion getDiscussionById(@PathVariable Long id) {
        return discussionService.getDiscussionById(id);
    }

    // Admin answers discussion
    @PutMapping("/{id}/answer")
    public Discussion answerDiscussion(
            @PathVariable Long id,
            @RequestParam String answer) {

        return discussionService.answerDiscussion(id, answer);
    }

    // Delete discussion
    @DeleteMapping("/{id}")
    public String deleteDiscussion(@PathVariable Long id) {

        discussionService.deleteDiscussion(id);

        return "Discussion deleted successfully";
    }
}