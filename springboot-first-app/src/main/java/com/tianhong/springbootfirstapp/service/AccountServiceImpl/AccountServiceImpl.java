package com.tianhong.springbootfirstapp.service.AccountServiceImpl;

import com.tianhong.springbootfirstapp.dao.AccountDao;
import com.tianhong.springbootfirstapp.dao.daoImpl.AccountDaoImpl;
import com.tianhong.springbootfirstapp.entity.Account;
import com.tianhong.springbootfirstapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public Account findByAccountId(int id) {
        return accountDao.findByAccountId(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
