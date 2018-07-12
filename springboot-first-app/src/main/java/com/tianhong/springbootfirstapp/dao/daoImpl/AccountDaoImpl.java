package com.tianhong.springbootfirstapp.dao.daoImpl;

import com.tianhong.springbootfirstapp.dao.AccountDao;
import com.tianhong.springbootfirstapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
    }

    @Override
    public int delete(int id) {
       return jdbcTemplate.update("DELETE from account where id=?", id);
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update account SET name=?, money=? WHERE id=?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public Account findByAccountId(int id) {
        List<Account> accountList = jdbcTemplate.query("SELECT * FROM account WHERE id="+id, new BeanPropertyRowMapper<Account>(Account.class));
        if(accountList.size() == 0) {
            return null;
        } else {
            return accountList.get(0);
        }
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * FROM account", new BeanPropertyRowMapper<Account>(Account.class));
    }
}
