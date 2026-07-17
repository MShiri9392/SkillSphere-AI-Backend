package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.entity.Wishlist;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import com.skillsphere.skillsphereaibackend.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Add Course to Wishlist
    public Wishlist addToWishlist(Long userId, Long courseId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        wishlist.setCourse(course);

        return wishlistRepository.save(wishlist);
    }

    // Get All Wishlist Items
    public List<Wishlist> getAllWishlist() {
        return wishlistRepository.findAll();
    }

    // Get Wishlist By Id
    public Wishlist getWishlistById(Long id) {
        return wishlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wishlist item not found"));
    }

    // Delete Wishlist Item
    public void deleteWishlist(Long id) {

        Wishlist wishlist = getWishlistById(id);

        wishlistRepository.delete(wishlist);
    }
}