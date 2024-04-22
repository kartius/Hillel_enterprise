package org.example.lesson_17_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BenchmarkAspect {

  @Pointcut("execution(public * org.example.lesson_17_aop.service.BussinessService.*(..))")
  public void benchmarkPontCut() {
  }

  @Around("benchmarkPontCut()")
  public Object benchmarkJoinPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long start = System.nanoTime();
    Object proceed = proceedingJoinPoint.proceed();
    long executionTime = System.nanoTime() - start;
    System.out.println(proceedingJoinPoint.getSignature() + " executed in " +executionTime +" ns");
    return proceed;
  }

}
