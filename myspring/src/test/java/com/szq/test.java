package com.szq;

import com.szq.myspring.bean.UserService;
import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testMySpring() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("myspring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();


    }
}
