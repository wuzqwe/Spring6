package com.szq.reflect;

import java.lang.reflect.Method;

public class Test03 {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.szq.reflect.SomeService");

        Method doSomeMethod = aClass.getDeclaredMethod("doSome");

        Object obj = aClass.newInstance();
        Object invoke = doSomeMethod.invoke(obj);
        System.out.println(invoke);
    }
}
