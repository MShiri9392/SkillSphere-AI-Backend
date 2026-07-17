package com.skillsphere.skillsphereaibackend.service;

import com.skillsphere.skillsphereaibackend.entity.Course;
import com.skillsphere.skillsphereaibackend.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @Test
    void testSaveCourse() {

        Course course = new Course();
        course.setTitle("Java");
        course.setDescription("Java Course");
        course.setInstructor("Shiri");
        course.setPrice(2500.0);

        when(courseRepository.save(course)).thenReturn(course);

        Course saved = courseService.saveCourse(course);

        assertEquals("Java", saved.getTitle());
        assertEquals("Shiri", saved.getInstructor());
        assertEquals(2500.0, saved.getPrice());
    }
}