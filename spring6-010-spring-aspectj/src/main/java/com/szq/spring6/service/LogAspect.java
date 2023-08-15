package com.szq.spring6.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect//切面类是需要使用@Aspect注解进行标注的
@Order(2)
public class LogAspect {//切面
    //切面=通知+切点
    //通知就是增强，就是具体的编写的增强代码
    //这里的Advice以方法的形式出现
    //@Before注解标注的方法就是一个前置通知。
    /*@Before("execution(* com.szq.spring6.service..*(..))")//切点表达式
    public void 增强(){
        System.out.println("我是一个通知，我是一段增强代码");
    }*/

    //定义通用的切点表达式
    @Pointcut("execution(* com.szq.spring6.service..*(..))")
    public void 通用切点(){
        //这个方法只是一个标记，方法名随意，方法体也不需要写任何代码
    }

    //前置通知
    @Before("通用切点()")//切点表达式
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("我是一个前置通知");
        //这个JoinPoint joinPoint，在Spring容器调用这个方法的时候自动传过来
        //获取目标方法分签名
        Signature signature = joinPoint.getSignature();
        //获取方法的方法名
        System.out.println("目标方法的方法名："+signature.getName());
    }

    //后置通知
    @AfterReturning("通用切点()")
    public void afterReturningAdvice(){
        System.out.println("我是一个后置通知");
    }
    //环绕通知（是最大的通知，在前置通知之前，在后置通知之后）
    @Around("通用切点()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //前面的代码
        System.out.println("前环绕");
        //执行目标
        joinPoint.proceed();
        //后面的代码
        System.out.println("后环绕");
    }
    //异常通知
    @AfterThrowing("通用切点()")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }
    //最终通知(finally语句块中的通知)
    @After("通用切点()")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}
