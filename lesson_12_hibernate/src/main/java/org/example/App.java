package org.example;

import org.example.config.HibernateSession;
import org.example.dao.CourseDAO;
import org.example.dao.StudentDAO;
import org.example.entity.Course;
import org.example.entity.utils.CourseUtils;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {



        try (SessionFactory sessionFactory = HibernateSession.sessionFactory()) {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            StudentDAO studentDAO = new StudentDAO(session);

            CourseDAO courseDAO = new CourseDAO(session);

            CourseUtils courseUtils = new CourseUtils();

            courseDAO.add(new Course("Java Enterprise"));

            List<Student> students = studentDAO.findAll();

            Course currentCourse = courseDAO.findById(1);

            courseUtils.addStudent(currentCourse, new Student("new", "new"));

            courseDAO.add(currentCourse);

            session.getTransaction().commit();


        }



    }
}
