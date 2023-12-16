package com.hibernatecourse.demo.repository;

import com.hibernatecourse.demo.entity.Course;
import com.hibernatecourse.demo.entity.CourseMatrial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMatrialRepositoryTest {

    @Autowired
    private CourseMatrialRepository courseMatrialRepository;
    @Test
    public void saveCourseMatrial() {
        Course course =
                Course.builder()
                        .title("java")
                        .credit(6)
                        .build();
        CourseMatrial courseMatrial =
                CourseMatrial.builder()
                        .url("http://www.courses1.com/hibernate")
                        .course(course)
                        .build();
        courseMatrialRepository.save(courseMatrial);

    }
    @Test
    public void printAllcourseMatrials() {
        List<CourseMatrial> courseMatrialList =
                courseMatrialRepository.findAll();
        System.out.println("Course Matrial List : " + courseMatrialList);

    }
}