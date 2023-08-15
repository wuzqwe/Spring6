package com.szq.spring6.bean;

import java.util.Date;

public class Student {
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }
    // TODO: 2023/2/6


    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
