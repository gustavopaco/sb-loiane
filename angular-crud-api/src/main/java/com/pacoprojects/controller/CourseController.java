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

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody @NonNull Course course) {
        final String RESOURCE_PATH = "/api/courses/" + courseService.createCourse(course).getId();
        return ResponseEntity.created(URI.create(RESOURCE_PATH)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable @NonNull Long id, @RequestBody @NonNull Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.noContent().build();
    }
}
