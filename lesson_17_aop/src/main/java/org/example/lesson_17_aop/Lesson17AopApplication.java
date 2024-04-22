package org.example.lesson_17_aop;

import org.example.lesson_17_aop.service.BussinessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson17AopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Lesson17AopApplication.class, args);
		BussinessService bussinessService = applicationContext.getBean(BussinessService.class);
		bussinessService.method1("ttt");
		bussinessService.method2();
	}
}
