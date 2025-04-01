package com.examly.springapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

    @Before("execution(* com.example.springapp.services.*.*(..))")
    public void beforeServiceExecution() {
        System.out.println("A service method is being executed.");
    }
}
