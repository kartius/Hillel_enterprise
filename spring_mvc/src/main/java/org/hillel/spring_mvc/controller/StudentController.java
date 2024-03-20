package org.hillel.spring_mvc.controller;

import org.hillel.spring_mvc.model.Student;
import org.hillel.spring_mvc.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StudentController {

  private StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(path = "/getStudents")
  public Map<Integer, Student> getStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping(path = "/getStudent")
  public Student getStudentByRequest(@RequestParam int id) {
    return studentService.getStudentById(id);
  }

  @GetMapping(path = "/getStudent/{id}")
  public Student getStudentByPath(@PathVariable int id) {
    return studentService.getStudentById(id);
  }
}
