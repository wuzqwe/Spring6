package com.szq.spring6.dao.impl;

import com.szq.spring6.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("删除用户");
    }
}
