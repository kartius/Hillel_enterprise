package org.example.lesson_13_spring_data;

import org.example.lesson_13_spring_data.dto.Student;
import org.example.lesson_13_spring_data.repository.jdbc.StudentJDBCDAO;
import org.example.lesson_13_spring_data.repository.jpa.StudentDAO;
import org.example.lesson_13_spring_data.repository.mybatis.StudentMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson13SpringDataApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(Lesson13SpringDataApplication.class, args);
//
//    StudentDAO studentDAO = applicationContext.getBean(StudentDAO.class);
//
//
//    System.out.println("---------Spring Data---------------");
//
//    for (Student student : studentDAO.findAll()) {
//
//      System.out.println(student);
//
//    }


//    System.out.println("------------------------");
//
//    Student studentsByNameAndEmail = studentDAO.getHilelelGoodStudentsByNameAndEmail("Timur", "email");
//    System.out.println(studentsByNameAndEmail);



//    System.out.println("------------SPRING JDBC TEMPLATE------------");


    StudentJDBCDAO studentJDBCDAO = applicationContext.getBean(StudentJDBCDAO.class);


    studentJDBCDAO.commit(false);


//    for (Student student : studentJDBCDAO.getAll()) {
//      System.out.println(student);
//    }


//    System.out.println(studentJDBCDAO.get(1));
//
//
//    System.out.println(studentJDBCDAO.get(1));
//
//
//    System.out.println("------------SPRING MyBatis------------");
//
//    StudentMapper studentMapper = applicationContext.getBean(StudentMapper.class);
//
//
//    for (Student student : studentMapper.getAllStudents()) {
//      System.out.println(student);
//    }






  }




}
