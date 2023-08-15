package com.szq.spring6.test;

import com.szq.spring6.bean.*;
import com.szq.spring6.jdbc.MyDataSource;
import com.szq.spring6.jdbc.MyDataSource1;
import com.szq.spring6.jdbc.MyDataSource2;
import com.szq.spring6.service.CustomerService;
import com.szq.spring6.service.OrderService;
import com.szq.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {
    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.savaUser();
    }

    @Test
    public void testConstructorDI() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring2.xml");
        CustomerService customerService = applicationContext.getBean("customerServiceBean", CustomerService.class);
        customerService.save();
    }

    @Test
    public void testSetDi2() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testSimpleTypeSet() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }

    @Test
    public void testSimpleTypeSet2() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("set-di.xml");
        SimpleValueType simpleValueBean = applicationContext.getBean("simpleValueBean", SimpleValueType.class);
        System.out.println(simpleValueBean);
    }

    @Test
    public void testMydataSource() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDataSourceBean = applicationContext.getBean("myDataSourceBean", MyDataSource.class);
        System.out.println(myDataSourceBean);
    }

    @Test
    public void testCascade(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("cascade.xml");
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        Clazz clazzBean = applicationContext.getBean("clazzBean", Clazz.class);
        System.out.println(studentBean);
        System.out.println(clazzBean);
    }

    @Test
    public void testArray() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe qianDaYeBean = applicationContext.getBean("qianDaYeBean", QianDaYe.class);
        System.out.println(qianDaYeBean);
    }

    @Test
    public void testcCollection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testNull() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Cat catBean = applicationContext.getBean("catBean", Cat.class);
        System.out.println(catBean);
    }

    @Test
    public void testSpecial() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }

    @Test
    public void testP() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testC() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testUtil() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);

        System.out.println(ds1);
        System.out.println(ds2);
    }

    @Test
    public void testAutowire() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-autowire.xml");
     /*   OrderService orderServiceBean = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderServiceBean.generate();*/
        CustomerService customerServiceBean = applicationContext.getBean("cs", CustomerService.class);
        customerServiceBean.save();
    }

    @Test
    public void testProperties() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }
}
