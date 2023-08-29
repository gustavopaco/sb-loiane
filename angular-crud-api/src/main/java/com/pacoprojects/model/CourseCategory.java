package com.pacoprojects.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_categories")
@Entity
public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_categories_gen")
    @SequenceGenerator(name = "course_categories_gen", sequenceName = "course_categories_seq", allocationSize = 1)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 10)
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 10, message = "Nome deve ter entre 3 e 10 caracteres")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "courseCategory", targetEntity = Course.class)
    @ToString.Exclude
    private Set<Course> courses = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseCategory that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
