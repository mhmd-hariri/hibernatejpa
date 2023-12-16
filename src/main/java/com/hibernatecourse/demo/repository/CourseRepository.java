package com.hibernatecourse.demo.repository;

import com.hibernatecourse.demo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findCoursesByTitleContaining(String title, Pageable pageable);
}
