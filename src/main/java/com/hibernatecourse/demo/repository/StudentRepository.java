package com.hibernatecourse.demo.repository;

import com.hibernatecourse.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{
  public  List<Student> findByFirstName(String firstName);
  public  List<Student>findByFirstNameContaining(String name);
  public List<Student> findByLastNameNotNull();
  public List<Student> findByGuardianName(String guardianName);
  public  List<Student> findByFirstNameAndLastName(String firstName,

                                                String lastName);
  //JPQL
  @Query("SELECT s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String EmailId);
  @Query("SELECT s.firstName from Student s where s.emailId = ?1")
 String getStudentFirstNameByEmailAddress(String EmailId);
  // Native Query
  @Query("SELECT s from Student s where s.emailId = ?1")
  Student getStudentByEmailAddressNative(String EmailId);
  // Query Named Params
    @Query("SELECT s from Student s where s.emailId = :emailId")
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String EmailId
    );
    @Transactional
    @Modifying
    @Query(
            value = "UPDATE tbl_student set first_name = :firstName where email_address = :emailId",
            nativeQuery = true
    )
    void updateFirstNameByEmailAddress(@Param("emailId") String emailId,@Param("firstName") String firstName);

}
