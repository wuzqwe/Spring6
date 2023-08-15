package com.szq.spring6.biz;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void saveUser(){
        System.out.println("新增用户信息");
    }
    public void deleteUser(){
        System.out.println("删除用户信息");
    }
    public void modifyUser(){
        System.out.println("修改用户信息");
    }
    public void getUser(){
        System.out.println("获取用户信息");
    }
}
