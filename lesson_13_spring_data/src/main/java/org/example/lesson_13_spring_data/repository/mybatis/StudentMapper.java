package org.example.lesson_13_spring_data.repository.mybatis;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.example.lesson_13_spring_data.dto.Student;

import java.util.List;

@Mapper
public interface StudentMapper {

  @Select("SELECT * FROM student")
  @Result(column = "studentid", property = "id")
  List<Student> getAllStudents();
}
