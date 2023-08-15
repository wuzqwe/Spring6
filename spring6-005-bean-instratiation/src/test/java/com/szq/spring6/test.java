package com.szq.spring6;

import com.szq.spring6.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    @Test
    public void testBean() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }

    @Test
    public void testStart() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Star starBeam = applicationContext.getBean("star", Star.class);
        System.out.println(starBeam);

    }

    @Test
    public void testBean2() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    @Test
    public void testBean3() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("personFactoryBean", Person.class);
        System.out.println(person);
    }

    @Test
    public void testDate() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }
}
