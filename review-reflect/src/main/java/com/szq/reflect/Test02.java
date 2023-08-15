package com.szq.reflect;

import java.lang.reflect.Method;

public class Test02 {
    public static void main(String[] args) throws Exception{
        //使用反射机制调用方法
        //获取类
        Class<?> clazz = Class.forName("com.szq.reflect.SomeService");

        //获取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

        //调用方法
        //四要素：调用哪个对象、哪个方法、传什么参数、返回什么值
        Object o = clazz.newInstance();
        Object retValue = doSomeMethod.invoke(o, "李四", 250);
        System.out.println(retValue);


    }
}
