package com.szq.bank.service.impl;

import com.szq.bank.dao.AccountDao;
import com.szq.bank.pojo.Account;
import com.szq.bank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;
    //控制事务，因为这个方法要完成所有转账业务
    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
        //开启事务
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance()<money) {
            throw new RuntimeException("余额不足!!");
        }
        //余额充足
        Account toAct = accountDao.selectByActno(toActno);


        //将内存中俩个对象的余额先修改
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);

        //数据库更新
        int count = accountDao.update(fromAct);
        //模拟异常
     /*   String s=null;
        s.toString();*/

        count+=accountDao.update(toAct);

        if (count!=2){
            throw new RuntimeException("转账失败，联系管理员");
        }
        //提交事务
        //回滚事务
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void withdraw(){

    }

    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act) {
        //这里调用dao的insert方法
        accountDao.insert(act);
        //创建账户对象
        Account act2=new Account("act-004",1000.0);
        try {
            accountService.save(act2);
        }catch (Exception e){

        }


    }
}
