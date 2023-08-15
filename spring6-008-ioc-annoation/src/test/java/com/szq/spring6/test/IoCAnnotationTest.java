package com.szq.spring6.test;

import cn.szq.Spring6Config;
import cn.szq.service.StudentService;
import com.szq.spring6.bean.Order;
import com.szq.spring6.bean.Student;
import com.szq.spring6.bean.User;
import com.szq.spring6.bean.Vip;
import com.szq.spring6.bean3.MyDataSource;
import com.szq.spring6.bean3.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.szq.service.OrderService;

public class IoCAnnotationTest {

    @Test
    public void testBeanComponent() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("user", User.class);
        System.out.println(userBean);
        Vip vipBean = applicationContext.getBean("vip", Vip.class);
        System.out.println(vipBean);
        Order orderBean = applicationContext.getBean("order", Order.class);
        System.out.println(orderBean);
        Student studentBean = applicationContext.getBean("student", Student.class);
        System.out.println(studentBean);
    }

    @Test
    public void testChoose() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-choose.xml");

    }

    @Test
    public void testDIByAnnotation() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-di.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void test() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-di.xml");
        Product product = applicationContext.getBean("product", Product.class);
        System.out.println(product);
    }

    @Test
    public void testAutoWire() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.save();
    }

    @Test
    public void testResource() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteByStudent();
    }

    @Test
    public void testNoXML() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.deleteByStudent();
    }
}
