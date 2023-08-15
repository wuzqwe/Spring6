package com.szq.proxy.util;

import com.szq.proxy.service.OrderService;
import com.szq.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * 封装一个工具方法，可以通过这个方法获取代理对象
 */
public class ProxyUtil {
    private ProxyUtil(){

    }

    public static Object newProxyInstance(Object target){
        //底层调用jdk调用的代理方法
        return  Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));
    }
}
