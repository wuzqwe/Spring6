package com.szq.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //这个方法在接口默认实现
    //默认返回true
    //如果想多例，直接将这个方法修改为return false；即可
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
