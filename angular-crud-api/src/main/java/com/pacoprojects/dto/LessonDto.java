package com.pacoprojects.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.pacoprojects.model.Lesson}
 */
public record LessonDto(Long id,
                        @NotBlank(message = "Nome é obrigatório") @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")String name,
                        @NotBlank(message = "URL do Youtube é obrigatório") @Size(min = 11, max = 11, message = "URL do Youtube deve ter 11 caracteres")String youtubeUrl) implements Serializable {
}
