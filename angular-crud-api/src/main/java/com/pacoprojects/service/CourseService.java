package com.pacoprojects.service;

import com.pacoprojects.exception.RecordNotFoundException;
import com.pacoprojects.model.Course;
import com.pacoprojects.repository.CourseRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(@NotNull Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Course createCourse(@NotNull Course course) {
        try {
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public void updateCourse(@NotNull Long id, @NotNull Course course) {
        if (!courseRepository.existsById(id)) {
            throw new RecordNotFoundException(id);
        }
        courseRepository.save(course);
    }

    public void deleteCourse(@NotNull Long id) {
        courseRepository.findById(id)
                .ifPresentOrElse(courseRepository::delete, () -> {
                    throw new RecordNotFoundException(id);
                });
    }
}
