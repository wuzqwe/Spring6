package com.szq.proxy.client;

import com.szq.proxy.service.OrderService;
import com.szq.proxy.service.OrderServiceImpl;
import com.szq.proxy.service.TimerInvocationHandler;
import com.szq.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

public class Client {
    //客户端程序
    public static void main(String[] args) {
        //创建目标对象
        OrderService target=new OrderServiceImpl();
        //创建代理对象
        /*
        * newProxyInstance翻译为：新建代理对象
        * 也就是说，通过调用这个方法可以创建代理对象
        * 本质上Proxy.newProxyInstance()方法的执行，做了俩件事：
        * 第一件事：在内存中动态生成了一个代理类的字节码class
        * 第二件事：new对象了。通过内存生成的代理类的代码，实例化了代理对象
        * 2.关于Proxy.newProxyInstance()方法的三个重要参数，每一个什么含义，有是你用
        * 第一个参数ClassLoader loader
        *       类加载器：这个类加载器有什么用
        *       在内存中当中生成的字节码也是class文件，要执行也得先加载到内存当中，加载类就需要类加载器。所以这里需要指定类加载器
        *       并且JDK要求，目标类的类加载器必须和代理类的类加载器必须使用同一个。
        * 第二个参数：Class<?>[] interface
        *       代理类和目标类要实现同一个接口或同一些接口
        * 第三个参数:InvocationHandler h
        *       调用处理器
        *       在调用处理器接口编写的就是：增强代码。
        *       因为具体要要增强什么代码，JDK动态代理技术它是猜不到的
        *       既然是接口就要写接口实现类。
        * */
      /*  OrderService orderService = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
      target.getClass().getInterfaces(), new TimerInvocationHandler(target));*/
        /*工具类封装方法*/
        OrderService orderService = (OrderService) ProxyUtil.newProxyInstance(target);
        //调用代理对象的代理方法
        orderService.generate();

    }
}
