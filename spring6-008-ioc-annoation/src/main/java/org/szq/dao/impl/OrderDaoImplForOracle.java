package org.szq.dao.impl;

import org.springframework.stereotype.Repository;
import org.szq.dao.OrderDao;

@Repository
public class OrderDaoImplForOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle正在保存订单信息。。。");
    }
}
