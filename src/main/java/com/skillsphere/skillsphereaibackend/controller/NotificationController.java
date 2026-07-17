package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Notification;
import com.skillsphere.skillsphereaibackend.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Create Notification
    @PostMapping("/{userId}")
    public Notification createNotification(
            @PathVariable Long userId,
            @Valid @RequestBody Notification notification) {

        return notificationService.createNotification(userId, notification);
    }

    // Get All Notifications
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // Get Notification By ID
    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    // Mark Notification as Read
    @PutMapping("/{id}/read")
    public Notification markAsRead(@PathVariable Long id) {
        return notificationService.markAsRead(id);
    }

    // Delete Notification
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {

        notificationService.deleteNotification(id);

        return "Notification deleted successfully";
    }
}