package org.example.lesson_13_spring_data.repository.jdbc;


import org.example.lesson_13_spring_data.dto.Student;
import org.example.lesson_13_spring_data.repository.jdbc.mapper.StudentMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentJDBCDAO {

  private JdbcTemplate jdbcTemplate;

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public StudentJDBCDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }



  @Transactional(propagation = Propagation.NEVER)
  public void commit(boolean isThrowException){

    jdbcTemplate.update("DELETE FROM student WHERE studentid=2");

    if (isThrowException) {
      throw new RuntimeException("Error DB");
    }

    jdbcTemplate.update("INSERT INTO student (name, email) VALUES (?, ?)", "test000", "test000");


  }


  public List<Student> getAll() {
    return jdbcTemplate.query("SELECT studentid AS id, name, email FROM student", new BeanPropertyRowMapper<>(Student.class));
  }


  public Student get(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM student WHERE studentid =?", new StudentMapper(), id);
  }


  public Student getParam(int id) {
    SqlParameterSource namedParameters =
            new MapSqlParameterSource().addValue("srudentid", id);

    return namedParameterJdbcTemplate.queryForObject("SELECT * FROM student WHERE studentid =:id", namedParameters, Student.class);

  }


  public void add() {
    jdbcTemplate.update("INSERT INTO student (name, email) VALUES (?, ?)", "test", "test");
  }


}
