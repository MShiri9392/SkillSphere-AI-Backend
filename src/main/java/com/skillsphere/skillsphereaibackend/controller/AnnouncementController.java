package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Announcement;
import com.skillsphere.skillsphereaibackend.service.AnnouncementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@CrossOrigin("*")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    // Create Announcement
    @PostMapping("/{courseId}")
    public Announcement createAnnouncement(
            @PathVariable Long courseId,
            @Valid @RequestBody Announcement announcement) {

        return announcementService.createAnnouncement(courseId, announcement);
    }

    // Get All Announcements
    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    // Get Announcement By ID
    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable Long id) {
        return announcementService.getAnnouncementById(id);
    }

    // Update Announcement
    @PutMapping("/{id}")
    public Announcement updateAnnouncement(
            @PathVariable Long id,
            @Valid @RequestBody Announcement announcement) {

        return announcementService.updateAnnouncement(id, announcement);
    }

    // Delete Announcement
    @DeleteMapping("/{id}")
    public String deleteAnnouncement(@PathVariable Long id) {

        announcementService.deleteAnnouncement(id);

        return "Announcement deleted successfully";
    }
}
