package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.entity.Payment;
import com.skillsphere.skillsphereaibackend.entity.User;
import com.skillsphere.skillsphereaibackend.exception.ResourceNotFoundException;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import com.skillsphere.skillsphereaibackend.repository.PaymentRepository;
import com.skillsphere.skillsphereaibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Make Payment
    public Payment makePayment(Long userId, Long courseId, Payment payment) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        payment.setUser(user);
        payment.setCourse(course);
        payment.setAmount(course.getPrice());
        payment.setStatus("SUCCESS");
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    // Get All Payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get Payment By ID
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
    }

    // Delete Payment
    public void deletePayment(Long id) {

        Payment payment = getPaymentById(id);

        paymentRepository.delete(payment);
    }
}