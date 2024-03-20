package org.hillel.spring_mvc.controller;

import org.hillel.spring_mvc.model.Student;
import org.hillel.spring_mvc.service.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller(value = "/student")
public class StudentSimpleController {

  private StudentService studentService;

  public StudentSimpleController(StudentService studentService) {
    this.studentService = studentService;
  }

//  @GetMapping(path = "/getStudents", consumes = "application/xml")
//  public @ResponseBody Map<Integer, Student> getStudents(){
//    return studentService.getAllStudents();
//  }

}
