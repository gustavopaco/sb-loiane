package com.pacoprojects.service;

import com.pacoprojects.dto.CourseDto;
import com.pacoprojects.exception.RecordNotFoundException;
import com.pacoprojects.mapper.CourseMapper;
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
    private final CourseMapper courseMapper;

    public List<CourseDto> getCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDto).toList();
    }

    public CourseDto getCourse(@NotNull Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public CourseDto createCourse(@NotNull CourseDto course) {
        try {
            return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(course)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public void updateCourse(@NotNull Long id, @NotNull CourseDto course) {
        courseRepository.save(courseMapper.partialUpdate(course, courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id))));
    }

    public void deleteCourse(@NotNull Long id) {
        courseRepository.findById(id)
                .ifPresentOrElse(courseRepository::delete, () -> {
                    throw new RecordNotFoundException(id);
                });
    }
}
