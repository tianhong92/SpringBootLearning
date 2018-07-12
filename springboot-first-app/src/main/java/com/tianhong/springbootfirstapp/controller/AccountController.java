package com.tianhong.springbootfirstapp.controller;

import com.tianhong.springbootfirstapp.entity.Account;
import com.tianhong.springbootfirstapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    /**
     * 获取所有account信息
     * @return
     */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<Account> listAccounts() {
        return accountService.findAll();
    }

    /**
     * 获取一个account信息
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Account findAccountById(@PathVariable("id") int id) {
        return accountService.findByAccountId(id);
    }

    /**
     *  更新account信息
     */
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name") String name,
                                @RequestParam(value="money") double money) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        int result = accountService.update(account);
        if(result == 1){
            return account.getName() + account.getMoney();
        } else {
            return "fail";
        }
    }


    /**
     *  添加一个account
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "name") String name, @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        int result = accountService.add(account);
        if(result == 1) {
            return account.toString();
        } else {
            return "Fail";
        }
    }

    /**
     *  删除一个account
     */
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("id") int id) {
        int result = accountService.delete(id);
        if(result == 1) {
            return "Account been deleted successfully!";
        } else {
            return "Fail";
        }
    }
}
