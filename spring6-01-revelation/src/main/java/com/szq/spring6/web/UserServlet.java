package com.szq.spring6.web;

import com.szq.spring6.service.Impl.UserServiceImpl;
import com.szq.spring6.service.UserService;

public class UserServlet{
    private UserService userService=new UserServiceImpl();

    public void deleteRequest(){
        userService.deleteUser();
    }
}
