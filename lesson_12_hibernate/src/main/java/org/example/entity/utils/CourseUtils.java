package org.example.entity.utils;

import org.example.entity.Course;
import org.example.entity.Student;

public class CourseUtils {

  public void addStudent(Course course, Student student) {
    course.getStudents().add(student);
  }



}
