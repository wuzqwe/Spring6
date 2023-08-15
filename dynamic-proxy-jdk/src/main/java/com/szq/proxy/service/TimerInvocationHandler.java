package com.szq.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 专门负责计时的一个调用处理器对象
 */
public class TimerInvocationHandler implements InvocationHandler {
    /*
    * invoke是jdk自己调用的调用方法时执行
    * 3.invoke方法的三个参数:
    * invoke方法是jdk负责调用的，所以JDk调用这个方法的时候会自动给我们传过来三个参数
    * 第一个参数：Object proxy代理对象的引用，这个参数使用较少
    * 第二个参数：Method method目标对象上的目标方法 (要执行 的目标方法)
    * 第三个参数：Object[] args 目标方法的实参
    * */
    private Object target;

    public TimerInvocationHandler(Object target) {
      this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke...");
        //调用目标对象上的目标方法
//        System.out.println("增强1");
        long begin = System.currentTimeMillis();
        Object value= method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end-begin)+"毫秒");
//d代理对象需要返回值时，需要返回value
        return value;
    }
}
