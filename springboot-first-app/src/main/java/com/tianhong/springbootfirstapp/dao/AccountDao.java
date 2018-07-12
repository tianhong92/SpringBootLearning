package com.tianhong.springbootfirstapp.dao;

import com.tianhong.springbootfirstapp.entity.Account;

import java.util.List;

public interface AccountDao {
    int add(Account account);

    int delete(int id);

    int update(Account account);

    Account findByAccountId(int id);

    List<Account> findAll();
}
