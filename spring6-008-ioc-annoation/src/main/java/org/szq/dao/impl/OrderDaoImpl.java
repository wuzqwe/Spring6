package org.szq.dao.impl;

import org.springframework.stereotype.Repository;
import org.szq.dao.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySql正在保存订单信息。。。");
    }
}
