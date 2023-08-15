package com.szq.spring6;

import com.szq.spring6.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring6.xml")
public class Spring6Test {

    @Autowired
    private User user;

    @Test
    public void testUser1() {
       ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.getName());
    }

    @Test
    public void testUser2() {
       /* ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);*/
        System.out.println(user.getName());
    }
}
