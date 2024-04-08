package org.example.lesson_13_spring_data.repository;

import org.example.lesson_13_spring_data.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student, Long> {

//  @Query(value = "SELECT * FROM student AS s", nativeQuery = true)
//  List<Student> findAll();


  Student getHilelelGoodStudentsByNameAndEmail(String name, String email);
}
