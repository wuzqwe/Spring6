package com.szq.reflect;

public class Test {
    public static void main(String[] args) {
        //不使用反射机制调用方法
        SomeService someService = new SomeService();
        someService.doSome();
        String ns = someService.doSome("ns");
        System.out.println(ns);
        String cfs = someService.doSome("cfs", 23);
        System.out.println(cfs);

        /*
        * 分析调用一个方法，当中包含有几个要素？四要素
        * 第一要素：调用哪个对象
        * 第二要素：调用哪个方法
        * 第三要素：调用方法时传什么参数
        * 第四要素：方法执行时结束之后的返回结果
        *
        * 调用哪个对象的哪个方法，传什么参数，返回什么值
        * */
    }
}
