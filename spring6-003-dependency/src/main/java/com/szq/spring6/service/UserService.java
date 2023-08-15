package com.szq.spring6.service;

import com.szq.spring6.dao.UserDao;

public class UserService {

    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //set注入的话，必须提供一个set方法
    //spring容器会调用这个方法来给userDao属性赋值
    public void savaUser(){
        //保存用户信息到数据库
        userDao.insert();
    }
}
