
package com.examly.springapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.examly.springapp.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Entering method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.examly.springapp.controller..*(..))",
                    returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        System.out.println("Exiting method: " + joinPoint.getSignature().getName());
    }
}
