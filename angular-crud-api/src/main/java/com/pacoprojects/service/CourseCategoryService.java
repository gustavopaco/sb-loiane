package com.pacoprojects.service;

import com.pacoprojects.model.CourseCategory;
import com.pacoprojects.repository.CourseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCategoryService {
    private final CourseCategoryRepository courseCategoryRepository;

    public List<CourseCategory> getAllCourseCategories() {
        return courseCategoryRepository.findAll();
    }
}
