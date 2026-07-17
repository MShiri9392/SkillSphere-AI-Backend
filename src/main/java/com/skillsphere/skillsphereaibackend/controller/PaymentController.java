package com.skillsphere.skillsphereaibackend.controller;

import com.skillsphere.skillsphereaibackend.entity.Payment;
import com.skillsphere.skillsphereaibackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Make Payment
    @PostMapping("/{userId}/{courseId}")
    public Payment makePayment(
            @PathVariable Long userId,
            @PathVariable Long courseId,
            @RequestBody Payment payment) {

        return paymentService.makePayment(userId, courseId, payment);
    }

    // Get All Payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get Payment By ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    // Delete Payment
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {

        paymentService.deletePayment(id);

        return "Payment deleted successfully";
    }
}