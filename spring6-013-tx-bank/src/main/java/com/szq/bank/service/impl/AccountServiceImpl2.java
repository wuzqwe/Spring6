package com.szq.bank.service.impl;

import com.szq.bank.dao.AccountDao;
import com.szq.bank.pojo.Account;
import com.szq.bank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act) {
        accountDao.insert(act);

        //模拟异常
        String s=null;
        s.toString();
    }
}
