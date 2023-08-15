package com.szq.spring6.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product{
    @Value("隔壁老王")
    private String name;
    @Value("30")
    private int age;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
