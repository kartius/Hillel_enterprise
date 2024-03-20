package org.hillel.spring_mvc.service;

import org.hillel.spring_mvc.exception.RandomHillelException;
import org.hillel.spring_mvc.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

  private final Map<Integer, Student> students = new HashMap<>();

  public void addStudent(Student student) {
    students.put(student.getId(), student);
  }

  public Student getStudentById(int id) {
    students.put(1, new Student(1, "test"));
    return students.get(id);
  }

  public Map<Integer, Student> getAllStudents() {
    students.put(1, new Student(1, "test"));

    throw new RandomHillelException("Server can't manage this request");
//    return students;
  }
}
