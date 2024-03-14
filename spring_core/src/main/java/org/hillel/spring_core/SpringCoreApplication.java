package org.hillel.spring_core;

import org.hillel.spring_core.model.Student;
import org.hillel.spring_core.service.OtherService;
import org.hillel.spring_core.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCoreApplication.class, args);

		StudentService studentService = applicationContext.getBean(StudentService.class);

		studentService.addStudent(new Student(1, "test"));

		OtherService otherService = applicationContext.getBean(OtherService.class);

		otherService.printAllStudents();
	}

}
