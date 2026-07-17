package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.entity.Discussion;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.DiscussionRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    // Create Discussion
    public Discussion createDiscussion(Long courseId, Long userId, Discussion discussion) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        discussion.setCourse(course);
        discussion.setUser(user);
        discussion.setCreatedAt(LocalDateTime.now());

        return discussionRepository.save(discussion);
    }

    // Get All Discussions
    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    // Get Discussion By ID
    public Discussion getDiscussionById(Long id) {
        return discussionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Discussion not found"));
    }

    // Answer Discussion
    public Discussion answerDiscussion(Long id, String answer) {

        Discussion discussion = getDiscussionById(id);

        discussion.setAnswer(answer);

        return discussionRepository.save(discussion);
    }

    // Delete Discussion
    public void deleteDiscussion(Long id) {

        Discussion discussion = getDiscussionById(id);

        discussionRepository.delete(discussion);
    }
}