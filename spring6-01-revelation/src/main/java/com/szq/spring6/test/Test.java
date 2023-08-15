package com.szq.spring6.test;

import com.szq.spring6.web.UserServlet;

public class Test {
    public static void main(String[] args) {
        UserServlet userServlet=new UserServlet();
        userServlet.deleteRequest();
    }
}
