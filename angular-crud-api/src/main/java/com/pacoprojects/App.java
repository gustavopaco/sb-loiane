package com.pacoprojects;

import com.pacoprojects.model.Course;
import com.pacoprojects.model.CourseCategory;
import com.pacoprojects.repository.CourseCategoryRepository;
import com.pacoprojects.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    CommandLineRunner initDataBase(CourseRepository courseRepository, CourseCategoryRepository courseCategoryRepository) {
//        return args -> {
//            courseRepository.deleteAll();
//            courseCategoryRepository.deleteAll();
//
//            CourseCategory courseCategory = new CourseCategory();
//            courseCategory.setName("Front-end");
//            courseCategory = courseCategoryRepository.save(courseCategory);
//
//            CourseCategory courseCategory1 = new CourseCategory();
//            courseCategory1.setName("Back-end");
//            courseCategory1 = courseCategoryRepository.save(courseCategory1);
//
//            courseRepository.saveAll(List.of(
//                    new Course(null, "Angular", "Curso de Angular v16", courseCategory),
//                    new Course(null, "React", "Curso de React JS", courseCategory),
//                    new Course(null, "Vue", "Curso de Vue JS", courseCategory),
//                    new Course(null, "Java", "Curso de Java avançado", courseCategory1),
//                    new Course(null, "Spring Boot", "Curso de Spring Boot v6", courseCategory1)
//            ));
//        };
//    }
}
