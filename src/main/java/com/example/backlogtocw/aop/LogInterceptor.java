package com.example.backlogtocw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOPによるログ出力
 */
@Aspect
@Component
public class LogInterceptor {

    @Before("execution(* com.example.backlogtocw.bean.*.*(..))")
    public void before(JoinPoint joinpoint) {
        System.out.println("--- log start: " + joinpoint.getSignature());
    }

    @After("execution(* com.example.backlogtocw.bean.*.*(..))")
    public void after(JoinPoint joinpoint) {
        System.out.println("--- log end: " + joinpoint.getSignature());
    }


}
