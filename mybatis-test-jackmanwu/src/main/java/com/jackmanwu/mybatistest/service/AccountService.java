package com.jackmanwu.mybatistest.service;

import com.jackmanwu.mybatistest.model.mapper.AccountMapper;
import com.jackmanwu.mybatistest.model.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JackManWu on 2019/6/7.
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public List<Account> getAccount() {
        return accountMapper.selectByExample(null);
    }

    public void updateAccount(Long accountId, String username) {
        Account account = new Account();
        account.setId(accountId);
        account.setUsername(username);
        accountMapper.updateByPrimaryKeySelective(account);
    }
}