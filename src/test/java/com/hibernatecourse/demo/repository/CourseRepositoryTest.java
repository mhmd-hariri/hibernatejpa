package com.hibernatecourse.demo.repository;

import com.hibernatecourse.demo.entity.Course;
import com.hibernatecourse.demo.entity.Student;
import com.hibernatecourse.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
 @Test
    public void printCourses() {
     List<Course> courses =
             courseRepository.findAll();
     System.out.println("courses List : " + courses);
 }
 //save after many to one relationship
 @Test
 public void saveCourseWithTeacher() {
     Teacher teacher = Teacher
             .builder()
             .firstName("test")
             .lastName("test")
             .build();
     Course course = Course
             .builder()
             .title("Python")
             .credit(8)
             .teacher(teacher)
             .build();

     courseRepository.save(course);
 }
 @Test
 public void findAllPagination()
 {
    Pageable firtsPageSpecification =
             PageRequest.of(0,2);
    Pageable secondPageSpecification =
            PageRequest.of(1,3);

    Page<Course> coursePage = courseRepository.findAll(secondPageSpecification);
    List<Course> courses =coursePage.getContent();
    Long elemntsCount = coursePage.getTotalElements();
    int pageCount = coursePage.getTotalPages();
    System.out.println("courses = " + courses);
    System.out.println("pagesCount: " + pageCount);
    System.out.println("elemntsCounts: " + elemntsCount);
 }
 @Test
    public void findAllSorting() {
     Pageable pageSortedbyTitel =
             PageRequest.of(
                     0,
                     2,
                     Sort.by("title")
             );
     Pageable pageSortedbycreditDesc =
             PageRequest.of(
                     0,
                     4,
                     Sort.by("credit").descending()
             );
     Pageable pageSortedbyTitelandCreditDesc =
             PageRequest.of(
                     0,
                     4,
                     Sort.by("title")
                             .descending()
                             .and(Sort.by("credit"))
             );
     Page<Course> coursePage = courseRepository.findAll(pageSortedbycreditDesc);
     System.out.println("courses = " + coursePage.getContent());
 }
 @Test
    public void findByTitleContaining()
 {
     Pageable pageSpecification =
             PageRequest.of(
                     0,
                     3,
                     Sort.by("title")
             );
     Page<Course> coursePage = courseRepository.findCoursesByTitleContaining("java", pageSpecification);
     System.out.println("courses: " + coursePage.getContent());
 }
 @Test
    public void saveCourseWithStudentAndTeacher(){
     Teacher teacher = Teacher
             .builder()
             .firstName("salem")
             .lastName("muharib")
             .build();
     ArrayList<Student> students = new ArrayList<Student> ();
     Student student1 = Student
                     .builder()
                     .firstName("shareef")
                     .lastName("hariri")
                     .emailId("sh.ha@gmail.com")
                     .build();
     Student student2 = Student
                     .builder()
                     .firstName("solaeman")
                     .lastName("hareere")
                     .emailId("so.ha@gmail.com")
                     .build();
      //students.add(student1);
     // students.add(student2);
     Course course = Course
             .builder()
             .title("java")
             .credit(12)
             .teacher(teacher)
             .build();
       course.addStudents(student1);
       course.addStudents(student2);
     courseRepository.save(course);

 }
}