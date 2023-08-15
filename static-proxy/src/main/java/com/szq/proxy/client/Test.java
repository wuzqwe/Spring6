package com.szq.proxy.client;

import com.szq.proxy.service.OrderService;
import com.szq.proxy.service.OrderServiceImpl;
import com.szq.proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
      /*  OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.detail();
        orderService.modify();*/

        OrderService target=new OrderServiceImpl();
        System.out.println("===================");
        OrderService proxy=new OrderServiceProxy(target);
        proxy.detail();
        proxy.generate();
        proxy.modify();
    }
}
