package com.szq.bank.service;

import com.szq.bank.pojo.Account;

public interface AccountService {
    /**
     * 转账方法
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno,String toActno,double money);

    /**
     * 保存账户信息
     * @param act
     */
    void save(Account act);
}
