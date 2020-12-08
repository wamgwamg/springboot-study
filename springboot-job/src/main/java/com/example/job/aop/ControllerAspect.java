package com.example.job.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author : wangye
 * @date: 2020-12-04
 * @description:
 */
@Component
@Slf4j
@Aspect
public class ControllerAspect {

    @Around("execution(* com.example.job.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {


        System.out.println("环绕之前："+System.currentTimeMillis());
        Object proceed = point.proceed();
        System.out.println("环绕之后："+System.currentTimeMillis());

        return proceed;
    }


}
