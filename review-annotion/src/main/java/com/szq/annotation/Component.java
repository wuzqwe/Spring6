package com.szq.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD,ElementType.TYPE})//标注注解的注解,叫做元注解。@Target注解用来修饰@Component可以出现的位置
@Retention(RetentionPolicy.RUNTIME)
//元注解。用来标注@Component注解最终保留在class文件当中，并且可以被反射机制读取
public @interface Component {

    //定义注解的属性
    //String是属性类型
    //value是属性名
    String value();


    //其他属性
    //属性类型的String
    //属性名是name
    //String name();
/*    String[] names();


    int[] ages();*/
}
