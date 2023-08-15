package com.szq.reflect;

import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("com.szq.reflect.User");

        Method setAge = clazz.getDeclaredMethod("setAge", int.class);

        User user =(User) clazz.newInstance();
        Object invoke = setAge.invoke(user, 20);
        System.out.println(user.getAge());
        System.out.println(user);

    }
}
