package org.example.lesson_13_spring_data.repository.jdbc.mapper;


import org.example.lesson_13_spring_data.dto.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
  @Override
  public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
    Student student = new Student();
    student.setId(rs.getLong("studentid"));
    student.setName(rs.getString("name"));
    student.setEmail(rs.getString("email"));
    return student;
  }
}
