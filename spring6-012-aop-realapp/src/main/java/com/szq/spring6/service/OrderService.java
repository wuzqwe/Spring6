package com.szq.spring6.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    //生成订单的业务方法
    public void generate(){
        System.out.println("正在生成订单...");
    }

    //取消订单的业务方法
    public void cancel(){
        System.out.println("订单已取消");
    }
}
