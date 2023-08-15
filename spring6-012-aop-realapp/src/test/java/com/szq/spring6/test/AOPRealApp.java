package com.szq.spring6.test;

import com.szq.spring6.biz.UserService;
import com.szq.spring6.biz.VipService;
import com.szq.spring6.service.AccountService;
import com.szq.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPRealApp {
    @Test
    public void testTransaction() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        accountService.transfer();
        accountService.withdraw();

        orderService.generate();
        orderService.cancel();
    }

    @Test
    public void testSecurityLog() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        VipService vipService = applicationContext.getBean("vipService", VipService.class);
        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        userService.getUser();


        vipService.saveVip();
        vipService.deleteVip();
        vipService.modifyVip();
        vipService.getVip();
    }
}
