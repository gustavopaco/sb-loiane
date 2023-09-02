package com.pacoprojects.service;

import com.pacoprojects.dto.CourseDto;
import com.pacoprojects.exception.RecordNotFoundException;
import com.pacoprojects.mapper.CourseMapper;
import com.pacoprojects.model.Course;
import com.pacoprojects.model.CourseCategory;
import com.pacoprojects.repository.CourseRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseCategoryService courseCategoryService;
    private final CourseMapper courseMapper;

    public List<CourseDto> getCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDto).toList();
    }

    public CourseDto getCourse(@NotNull Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public CourseDto createCourse(@NotNull CourseDto courseDto) {
        try {
            return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(courseDto)));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public void updateCourse(@NotNull Long id, @NotNull CourseDto courseDto) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        if (courseDto.courseCategory().id() != null && !Objects.equals(courseDto.courseCategory().id(), course.getCourseCategory().getId())) {
            CourseCategory courseCategory = courseCategoryService.getCourseCategory(courseDto.courseCategory().id());
            courseCategory.removeCourse(course);
            courseCategory.addCourse(course);
        }
        courseRepository.save(courseMapper.partialUpdate(courseDto, course));
    }

    public void deleteCourse(@NotNull Long id) {
        courseRepository.findById(id)
                .ifPresentOrElse(courseRepository::delete, () -> {
                    throw new RecordNotFoundException(id);
                });
    }
}
