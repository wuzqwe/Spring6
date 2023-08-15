package com.szq.spring6.bean;

/**
 * 具体工厂角色
 * 一个产品对应一个工厂
 */
public class GunFactory {
    //工厂方法模式的具体工厂角色的方法是：实例方法
    public Gun get(){
        return new Gun();
    }
}
