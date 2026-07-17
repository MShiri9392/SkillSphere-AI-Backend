package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Announcement;
import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.AnnouncementRepository;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Create Announcement
    public Announcement createAnnouncement(Long courseId, Announcement announcement) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        announcement.setCourse(course);
        announcement.setCreatedAt(LocalDateTime.now());

        return announcementRepository.save(announcement);
    }

    // Get All Announcements
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    // Get Announcement By ID
    public Announcement getAnnouncementById(Long id) {
        return announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found"));
    }

    // Update Announcement
    public Announcement updateAnnouncement(Long id, Announcement updatedAnnouncement) {

        Announcement announcement = getAnnouncementById(id);

        announcement.setTitle(updatedAnnouncement.getTitle());
        announcement.setMessage(updatedAnnouncement.getMessage());

        return announcementRepository.save(announcement);
    }

    // Delete Announcement
    public void deleteAnnouncement(Long id) {

        Announcement announcement = getAnnouncementById(id);

        announcementRepository.delete(announcement);
    }
}