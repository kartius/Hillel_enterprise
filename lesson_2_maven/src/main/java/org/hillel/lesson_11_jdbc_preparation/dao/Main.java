package org.hillel.lesson_11_jdbc_preparation.dao;


import org.hillel.lesson_11_jdbc_preparation.dto.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/enterprise";
        String username = "admin";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            StudentDAO studentDAO = new StudentDAO(connection);


            studentDAO.addStudent(new Student("TEst", "test", "test"));

            System.out.println(studentDAO.getStudents());

        }
    }
}
