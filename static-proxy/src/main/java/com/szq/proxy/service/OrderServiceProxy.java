package com.szq.proxy.service;
/*
*
* 代理对象（代理对象和目标对象具有相同的行为，就要实现同一个接口或同一些接口）
* 客户端在使用代理对象的时候就像在使用目标对象一样
* */
public class OrderServiceProxy implements OrderService{
    //将目标对象作为代理对象的一个属性。这种关系叫做关联关系。比继承关系的耦合度低
    //代理对象中含有目标对象的引用。关联关系has a
    //注意：这里要写另一个公共接口类型。因为公共接口耦合度低
    private OrderService target;//这是目标对象。目标对象一定实现OrderService接口的

    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {//代理方法
        long begin = System.currentTimeMillis();
        //调用目标对象的方法
        target.generate();
        long end=System.currentTimeMillis();
        System.out.println("耗时"+(end-begin)+"毫秒");
    }

    @Override
    public void modify() {//代理方法
        long begin = System.currentTimeMillis();
        target.modify();
        long end=System.currentTimeMillis();
        System.out.println("耗时"+(end-begin)+"毫秒");
    }

    @Override
    public void detail() {//代理方法
        long begin = System.currentTimeMillis();
        target.detail();
        long end=System.currentTimeMillis();
        System.out.println("耗时"+(end-begin)+"毫秒");
    }
}
