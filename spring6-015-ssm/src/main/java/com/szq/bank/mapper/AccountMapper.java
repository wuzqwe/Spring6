package com.szq.bank.mapper;

import com.szq.bank.pojo.Account;

import java.util.List;

public interface AccountMapper {//该接口的实现类不需要写，是mybatis通过动态代理机制生成的实现类

    //这就是DAO,只需要编写CRUD方法就行

    /**
     * 新增账户
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 删除账户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 按账号查询账户
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查询所有账户
     * @return
     */
    List<Account> selectAll();

}
