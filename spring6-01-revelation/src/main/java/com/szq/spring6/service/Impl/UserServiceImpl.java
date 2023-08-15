package com.szq.spring6.service.Impl;

import com.szq.spring6.dao.UserDao;
import com.szq.spring6.dao.impl.UserDaoImpl;
import com.szq.spring6.service.UserService;

public class UserServiceImpl implements UserService {

//    private UserDao userDao=new UserDaoImpl();
    private UserDao userDao;
    @Override
    public void deleteUser() {
        System.out.println(userDao);
        userDao.deleteById();
    }
}
