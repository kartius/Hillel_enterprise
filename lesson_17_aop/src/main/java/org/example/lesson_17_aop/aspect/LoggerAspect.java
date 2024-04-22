package org.example.lesson_17_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

  @Pointcut("execution(public * org.example.lesson_17_aop.service.BussinessService.*(..))")
  public void loggingPontCut(){}

  @Before("loggingPontCut()")
  public void beforeJoinPointLogging(JoinPoint joinPoint){
    System.out.println("before logging");
  }

  @After("loggingPontCut()")
  public void afterJoinPointLogging(){
    System.out.println("after logging");
  }
}
