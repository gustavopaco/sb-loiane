package com.pacoprojects.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.pacoprojects.model.CourseCategory}
 */
public record CourseCategoryDto(Long id,
                                @Size(message = "Nome deve ter entre 3 e 10 caracteres", min = 3, max = 10) @NotBlank(message = "Nome é obrigatório") String name) implements Serializable {
}
