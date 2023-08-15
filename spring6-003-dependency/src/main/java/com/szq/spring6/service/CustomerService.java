package com.szq.spring6.service;

import com.szq.spring6.dao.OrderDao;
import com.szq.spring6.dao.UserDao;

public class CustomerService {

    private UserDao userDao;

 /*   public CustomerService(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
