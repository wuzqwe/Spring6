package com.szq.proxy.service;

public class OrderServiceImpl implements OrderService{

    @Override
    public void generate(){
        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成");
        long end = System.currentTimeMillis();
        System.out.println(end-begin);

    }

    @Override
    public void modify() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改。");
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请看订单详情");
    }
}
