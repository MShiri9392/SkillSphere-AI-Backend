package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Announcement;
import com.skillsphere.skillsphereaibackend.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@CrossOrigin(origins = "http://localhost:5173")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // Create Announcement
    @PostMapping("/{courseId}")
    public Announcement createAnnouncement(
            @PathVariable Long courseId,
            @RequestBody Announcement announcement) {

        return announcementService.createAnnouncement(courseId, announcement);
    }

    // Get All Announcements
    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    // Get Announcement By Id
    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable Long id) {
        return announcementService.getAnnouncementById(id);
    }

    // Update Announcement
    @PutMapping("/{id}")
    public Announcement updateAnnouncement(
            @PathVariable Long id,
            @RequestBody Announcement announcement) {

        return announcementService.updateAnnouncement(id, announcement);
    }

    // Delete Announcement
    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
    }
}