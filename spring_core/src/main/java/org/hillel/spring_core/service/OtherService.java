package org.hillel.spring_core.service;

import org.hillel.spring_core.component.MyComponent;
import org.hillel.spring_core.config.ConfigApp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OtherService {


    @Autowired
    private ConfigApp configApp;

    @Autowired
    private List<MyComponent> myComponentList;

    private final StudentService studentService;



    public OtherService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void printAllStudents(){
        myComponentList.size();
        System.out.println(configApp.getValue());

        System.out.println(studentService.getStudents());
    }
}
