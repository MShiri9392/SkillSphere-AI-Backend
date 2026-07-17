package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Wishlist;
import com.skillsphere.skillsphereaibackend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin("*")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    // Add Course to Wishlist
    @PostMapping("/{userId}/{courseId}")
    public Wishlist addToWishlist(
            @PathVariable Long userId,
            @PathVariable Long courseId) {

        return wishlistService.addToWishlist(userId, courseId);
    }

    // Get All Wishlist
    @GetMapping
    public List<Wishlist> getAllWishlist() {
        return wishlistService.getAllWishlist();
    }

    // Get Wishlist By Id
    @GetMapping("/{id}")
    public Wishlist getWishlistById(@PathVariable Long id) {
        return wishlistService.getWishlistById(id);
    }

    // Delete Wishlist
    @DeleteMapping("/{id}")
    public String deleteWishlist(@PathVariable Long id) {

        wishlistService.deleteWishlist(id);

        return "Wishlist item deleted successfully";
    }
}