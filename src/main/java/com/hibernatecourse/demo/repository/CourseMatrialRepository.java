package com.hibernatecourse.demo.repository;

import com.hibernatecourse.demo.entity.CourseMatrial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMatrialRepository extends JpaRepository<CourseMatrial,Long> {
}
