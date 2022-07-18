package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    /*
    * 1. * -> 所有返回值
    * 2. * -> 所有類
    * 3. * -> 所有方法
    * 4. (..) -> 所有參數
    */
    @Around("execution(* com.example.demo.service.impl.*.*(..))")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();

        System.out.println("耗時: "+ (end-start) + " 毫秒");
        return result;
    }
}
