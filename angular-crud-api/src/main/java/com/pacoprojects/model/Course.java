package com.pacoprojects.model;

import com.pacoprojects.enums.Status;
import com.pacoprojects.enums.converter.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@SQLDelete(sql = "UPDATE courses SET status = 'Deletado' WHERE id = ?")
@Where(clause = "status <> 'Deletado'")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_gen")
    @SequenceGenerator(name = "courses_gen", sequenceName = "courses_seq", allocationSize = 1)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 3, max = 255, message = "Descrição deve ter entre 3 e 255 caracteres")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_category_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "courses_course_category_id_fk", value = ConstraintMode.CONSTRAINT))
    @ToString.Exclude
    @NotNull(message = "Categoria é obrigatória")
    private CourseCategory courseCategory;

    @Column(name = "status", length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    @NotBlank(message = "Status é obrigatório")
    private Status status = Status.ACTIVE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
