package com.szq.spring6.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class SecurityLogAspect {

    @Pointcut("execution(* com.szq.spring6.biz..save*(..))")
    public void savePoint(){

    }
    @Pointcut("execution(* com.szq.spring6.biz..delete*(..))")
    public void deletePoint(){

    }
    @Pointcut("execution(* com.szq.spring6.biz..modify*(..))")
    public void modifyPoint(){

    }
    @Pointcut("execution(* com.szq.spring6.biz..get*(..))")
    public void getPoint(){

    }

    @Before("savePoint()||deletePoint()||modifyPoint()||getPoint()")
    public void beforeAdvice(JoinPoint joinPoint){
        //系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String nowTime = sdf.format(new Date());
        //输出日志信息
        System.out.println(nowTime+" zhangsan:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }
}
