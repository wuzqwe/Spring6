package com.szq.client;

import com.szq.annotation.Component;

public class ReflectAnnotationTest1 {
    public static void main(String[] args) throws Exception{
        //通过反射机制读取注解
        //获取类
        Class<?> clazz = Class.forName("com.szq.bean.User");
        //判断类上面有没有注解
        if (clazz.isAnnotationPresent(Component.class)) {
            //获取类上的注解
            Component annotation = clazz.getAnnotation(Component.class);
            //访问注解的属性
            System.out.println(annotation.value());
        }
    }
}
