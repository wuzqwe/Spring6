package com.szq.spring6.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    //注入List集合
    private List<String> names;


    //注入Set集合
    private Set<String> addrs;

    private Map<Integer,String> phone;

    //Hashtable实现Map接口,Map<String,String>类型
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addrs=" + addrs +
                ", phone=" + phone +
                ", properties=" + properties +
                '}';
    }

    public void setPhone(Map<Integer, String> phone) {
        this.phone = phone;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

}
