package com.szq.spring6.service;

import com.szq.spring6.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /*生成订单的set方法*/
    public void generate(){
        orderDao.generate();
    }
}
