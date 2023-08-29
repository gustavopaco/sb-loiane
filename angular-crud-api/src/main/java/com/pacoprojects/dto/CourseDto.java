package com.pacoprojects.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.pacoprojects.model.Course}
 */
public record CourseDto(Long id,
                        @Size(message = "Nome deve ter entre 3 e 100 caracteres", min = 3, max = 100) @NotBlank(message = "Nome é obrigatório") String name,
                        @Size(message = "Descrição deve ter entre 3 e 255 caracteres", min = 3, max = 255) @NotBlank(message = "Descrição é obrigatória") String description,
                        @NotNull(message = "Categoria é obrigatória") CourseCategoryDto courseCategory,
                        @NotNull Set<LessonDto> lessons) implements Serializable {
}
