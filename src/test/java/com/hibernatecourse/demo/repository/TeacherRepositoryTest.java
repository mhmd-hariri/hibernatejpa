package com.hibernatecourse.demo.repository;

import com.hibernatecourse.demo.entity.Course;
import com.hibernatecourse.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveCourseOfTeacher()
    {
        List<Course> courses = List.of(
                Course.builder()
                        .title("course2")
                        .credit(3)
                        .build(),
                Course.builder()
                        .title("course4")
                        .credit(7)
                        .build()
        );
        Teacher teacher =
                Teacher.builder()
                        .firstName("aa")
                        .lastName("bb")
                        //.courses(courses)
                        .build();
        teacherRepository.save(teacher);


    }
}