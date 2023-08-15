package com.szq.proxy.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //增强代码
        long begin = System.currentTimeMillis();
        //怎么调用目标对象的目标方法
        Object retValue = methodProxy.invokeSuper(target, objects);
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-begin)+"毫秒");
        return retValue;
    }
}
