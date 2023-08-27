package com.pacoprojects.repository;

import com.pacoprojects.model.CourseCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Long> {
}
