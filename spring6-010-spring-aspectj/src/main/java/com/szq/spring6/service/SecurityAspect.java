package com.szq.spring6.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)//如果有多个切面谁的数字越小，优先级越高
public class SecurityAspect {//安全切面
    //通知+切点
    @Before("com.szq.spring6.service.LogAspect.通用切点()")
    public void beforeAdvice(){
        System.out.println("前置通知：安全...");
    }
}
