package com.szq.spring6.test;

import com.szq.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {

    /*
    * 1.Spring默认情况下是如何管理bean的
    * 默认情况下Bean是单例的（singleton）
    *在Spring上下文初始化的时候实例化
    * 每一次调用getBean()方法的时候，都返回那个单例的对象
    * 2.当将bean的scope的属性设置为prototype
    * bean是多列的
    * spring的上下文初始化这些prototype的bean
    * 每一次调用getBean()方法的时候，实例化该对象
    * prototype原型
    * */
    @Test
    public void testBeanScope() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }

    @Test
    public void testThreadScope() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);

        SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb1 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb1);
                SpringBean sb2 = applicationContext.getBean("sb", SpringBean.class);
                System.out.println(sb2);
            }
        }).start();
    }
}
