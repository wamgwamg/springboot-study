package com.example.job.aop;

import com.example.job.controller.RedirectController;
import com.example.job.utils.HttpCurl;
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


        System.out.println("环绕之前：" + System.currentTimeMillis());
        boolean b = point.getTarget() instanceof RedirectController;
        System.out.println("instanceof RedirectController  " + b);
        Object proceed = point.proceed();
        System.out.println("环绕之后：" + System.currentTimeMillis());
        HttpCurl.curl();

        return proceed;
    }


}
