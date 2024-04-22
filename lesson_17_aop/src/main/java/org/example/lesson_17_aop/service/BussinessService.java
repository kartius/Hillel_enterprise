package org.example.lesson_17_aop.service;

import org.springframework.stereotype.Service;

@Service
public class BussinessService {

  public void method1(String a){
    System.out.println("method1");
  }

  public void method2(){
    System.out.println("method2");
  }
}
