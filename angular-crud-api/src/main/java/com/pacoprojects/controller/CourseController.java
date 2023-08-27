package com.pacoprojects.controller;

import com.pacoprojects.model.Course;
import com.pacoprojects.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@Validated
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable @NotNull @Positive Long id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody @Valid @NotNull Course course) {
        final String RESOURCE_PATH = "/api/courses/" + courseService.createCourse(course).getId();
        return ResponseEntity.created(URI.create(RESOURCE_PATH)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable @NotNull @Positive Long id,
                                             @RequestBody @Valid @NotNull Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable @NotNull @Positive Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
