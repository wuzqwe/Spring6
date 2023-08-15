package com.szq.spring6.test;

import com.szq.bank.pojo.Account;
import com.szq.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SMTest {

    @Test
    public void testSM() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSM2() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        List<Account> list=accountService.getAll();
        list.forEach(lists->{
            System.out.println(lists);
        });
    }
}
