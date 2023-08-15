package com.szq.spring6;

import com.szq.spring6.bean.Student;
import com.szq.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
        /*
        * Spring容器只对singleton的Bean进行完整的生命周期管理
        * 如果是prototype的作用域的Bean，Spring容器只负责将该Bean的初始化完毕。等客户端程序一旦获取到该Bean之后，Spring容器就不再管理该对象 生命周期了。
        * */
    @Test
    public void testBean() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring6.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第四步：使用Bean"+user);
//        必须手动关闭Spring容器，这样Spring容器才会销毁Bean
        ClassPathXmlApplicationContext applicationContext1 = (ClassPathXmlApplicationContext) applicationContext;
        applicationContext1.close();
    }

    @Test
    public void testRegisterBean() {
        //自己new对象
        Student student = new Student();
        System.out.println(student);

        //将以上自己new的这个对象纳入Spring容器来管理。半路上交给Spring来管理
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerSingleton("studentBean",student);

        //从spring容器获取
        Object studentBean = defaultListableBeanFactory.getBean("studentBean");
        System.out.println(studentBean);
    }
}
