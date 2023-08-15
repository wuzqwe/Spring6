package com.szq.spring6.bean;

import java.util.Date;

public class Dog {
    private String name;
    private int age;

    private Date birth;

    //p命名注入底层还是set注入，只不过p命名空间注入可以让spring配置变得更加简单
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
