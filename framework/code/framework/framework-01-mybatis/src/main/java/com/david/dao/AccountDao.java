package com.david.dao;

import com.david.domain.Account;
import com.david.domain.AccountUser;

import java.util.List;

/**
 * @author david
 * @create 2019-06-26 10:48
 */
public interface AccountDao {
    List<Account> findAllCount();

    List<AccountUser> findAccountAndUser();

    List<Account> findAccountAndUserMybatis();

    List<Account> findAccountAndUserLazy();
}
