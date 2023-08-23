package com.pacoprojects.controller;

import com.pacoprojects.model.CourseCategory;
import com.pacoprojects.service.CourseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course-category")
@RequiredArgsConstructor
public class CourseCategoryController {
    private final CourseCategoryService courseCategoryService;

    @GetMapping
    public ResponseEntity<List<CourseCategory>> getAllCourseCategories() {
        return ResponseEntity.ok(courseCategoryService.getAllCourseCategories());
    }
}
