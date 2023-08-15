package com.szq.spring6.test;

import com.szq.bank.SpringConfig;
import com.szq.bank.pojo.Account;
import com.szq.bank.service.AccountService;
import com.szq.bank.service.impl.AccountServiceImpl;
import com.szq.bank.service.impl.IsolationService1;
import com.szq.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testSpring() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
//        System.out.println(accountService);
        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testPropagation() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account act=new Account("act-003",1000.0);
        accountService.save(act);
    }

    @Test
    public void testIsolation1() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-004");
    }

    @Test
    public void testIsolation2() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act=new Account("act-004",1000.0);
        i2.save(act);
    }

    @Test
    public void testNoXml() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
//        System.out.println(accountService);
        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
