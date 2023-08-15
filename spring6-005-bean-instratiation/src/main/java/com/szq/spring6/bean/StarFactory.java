package com.szq.spring6.bean;

/**
 * 简单工厂模式中的工厂类的角色。星工厂
 */
public class StarFactory {
//    工厂模式中有一个静态方法
//    简单工厂模式又叫做静态工厂方法模式
    public static Star get(){
        return new Star();
    }
}
