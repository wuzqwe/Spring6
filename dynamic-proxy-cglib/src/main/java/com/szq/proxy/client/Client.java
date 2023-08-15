package com.szq.proxy.client;

import com.szq.proxy.service.TimeMethodInterceptor;
import com.szq.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        //创建字节码增强对象
        //这个对象是CGLiB库当中的核心对象，就是依靠它来生成代理对象
        Enhancer enhancer = new Enhancer();
        //告诉CGLIB父类是谁。告诉CGLIB目标类是谁
        enhancer.setSuperclass(UserService.class);

        //设置回调（等同于jdkInvocationHandler调用处理器 方法拦截器）
        enhancer.setCallback(new TimeMethodInterceptor());

        //创建代理对象
        //这一步会做俩件事
        //第一件是：在内存中生成UserService类的子类，其实就是代理类的字节码
        //第二件事：创建代理对象
        UserService userServiceProxy = (UserService) enhancer.create();
        //
        boolean success = userServiceProxy.login("admin", "123");
        System.out.println(success? "登录成功":"登录失败");

        userServiceProxy.logout();
    }
}
