package com.szq.proxy.service;

public class UserService {
    //目标方法
    public boolean login(String username,String password){
        if ("admin".equals(username)&&"123".equals(password)) {
            return true;
        }
        return false;
    }

    public void logout(){
        System.out.println("系统正在退出...");
    }
}
