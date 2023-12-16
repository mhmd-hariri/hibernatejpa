package com.hibernatecourse.demo.repository;
import com.hibernatecourse.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;
  /*  @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("s.hareere500@gmail37.com")
                .firstName("shareef")
                .lastName("hariri")
                //.guardianName("mansoor")
                //.guardianEmail("shareef198860@yahoo.com")
                //.guardianMobile("+491623419347")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentwithGuardian() {
        Guardian guardian = Guardian.
                builder()
                .email("mansoor.hariri22@gmail.com")
                .name("mansoor")
                .mobile("+491623419347")
                .build();
        Student student = Student.builder()
                .firstName("mohammad")
                .lastName("hariri")
                .emailId("mohammad.hariri34@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }*/
    @Test
    public  void printAllstudents() {
        List<Student> students =
                studentRepository.findAll();
        System.out.println("Student_List: " + students);
    }
    @Test
    public void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("shareef");
        System.out.println("Student_List: " + students);
    }
    @Test
    public  void PrintStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Mansoor");
        System.out.println("Student_List: " + students);
    }
    @Test
    public  void PrintGetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress("s.hareere500@gmail.com");
        System.out.println("Student : " + student);
    }
    @Test
    public  void PrintGetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("s.hareere500@gmail.com");
        System.out.println("Student_FirstName : " + firstName);
    }
    @Test
    public void  printGetStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative("s.hareere500@gmail.com");
        System.out.println("Student : " + student);
    }
    @Test
    public void  printGetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("s.hareere500@gmail.com");
        System.out.println("Student : " + student);
    }
    @Test
    public  void updateFirstNameByEmailAddress() {
        studentRepository.updateFirstNameByEmailAddress("s.hareere500@gmail.com","sharif");
    }



}