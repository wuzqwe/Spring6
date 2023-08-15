package com.szq.spring6;

import com.szq.spring6.bean.Husband;
import com.szq.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testCd() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println(husband);
        Wife women = applicationContext.getBean("wife", Wife.class);
        System.out.println(women);
    }
}
