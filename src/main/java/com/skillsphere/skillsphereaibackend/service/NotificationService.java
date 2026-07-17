package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Notification;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.NotificationRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    // Create Notification
    public Notification createNotification(Long userId, Notification notification) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        notification.setUser(user);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRead(false);

        return notificationRepository.save(notification);
    }

    // Get All Notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Get Notification By ID
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
    }

    // Mark as Read
    public Notification markAsRead(Long id) {

        Notification notification = getNotificationById(id);

        notification.setRead(true);

        return notificationRepository.save(notification);
    }

    // Delete Notification
    public void deleteNotification(Long id) {

        Notification notification = getNotificationById(id);

        notificationRepository.delete(notification);
    }
}