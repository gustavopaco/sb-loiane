package com.pacoprojects.controller;

import com.pacoprojects.model.Course;
import com.pacoprojects.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody @NonNull Course course) {
        final String resourcePath = "/api/courses/" + courseService.createCourse(course).getId();
        return ResponseEntity.created(URI.create(resourcePath)).build();
    }
}
