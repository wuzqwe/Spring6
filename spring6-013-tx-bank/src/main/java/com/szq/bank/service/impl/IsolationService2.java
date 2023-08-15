package com.szq.bank.service.impl;

import com.szq.bank.dao.AccountDao;
import com.szq.bank.pojo.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Transactional(timeout = 10)//设置事务超时时间为10秒
    public void save(Account act){
        //睡眠一会
        try {
            Thread.sleep(1000*20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.insert(act);

    }
}
