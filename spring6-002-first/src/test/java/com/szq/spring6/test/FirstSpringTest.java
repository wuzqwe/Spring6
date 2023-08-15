package com.szq.spring6.test;

import com.szq.spring6.bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpring() {
        //第一步：获取Spring容器对象
        //ApplicationContext是一个接口
        //ApplicationContext有很多实现类  其中一个实现类叫ClassPathXmlApplicationContext
        //ClassPathXmlApplicationContext专门从类路径当中加载spring配置文件的一个spring上下文对象的
        //这行代码只要执行：就相当于启动了Spring容器，解析spring.xml文件，并实例化所有bean对象放到spring容器当中
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");

        //第二步：根据bean的id从Spring容器中获取这个对象
        User userBean= applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);

        Object userDaoImplBean = applicationContext.getBean("userDaoImplBean");
        System.out.println(userDaoImplBean);

    }

    @Test
    public void testBeginInitBean() {
        new ClassPathXmlApplicationContext("spring.xml");
        //你自己专门使用log4j2记录日志的
        //第一步，创建日志记录器对象
        //获取FirstSpringTest这个类的日志记录器对象，也就是说FirstSpringTest类中的代码执行记录日志的话，就会输出相关的日志信息
         Logger logger= LoggerFactory.getLogger(FirstSpringTest.class);

         //第二步：记录日志，根据不同的级别来输出日志
        logger.info("我是第一条信息");
        logger.debug("我是一条调试信息");
        logger.error("我是一条错误信息");
    }
}
