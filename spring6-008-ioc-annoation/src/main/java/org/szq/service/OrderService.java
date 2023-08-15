package org.szq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.szq.dao.OrderDao;

@Service
public class OrderService {
    //  @Autowired不需要指定任何属性，直接使用这个注解即可
    //这个注解的作用是根据类型byType进行的自动装配
    @Autowired
    @Qualifier("orderDaoImplForOracle")
    private OrderDao orderDao;

    //如果想解决以上问题，只能根据名字进行装配
    //Autowired与Qualifier

    public void save(){
        orderDao.insert();
    }
}
