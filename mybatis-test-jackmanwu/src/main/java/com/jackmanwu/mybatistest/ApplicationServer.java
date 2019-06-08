package com.jackmanwu.mybatistest;

import com.jackmanwu.mybatistest.model.pojo.Account;
import com.jackmanwu.mybatistest.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by JackManWu on 2019/6/7.
 */
@Slf4j
public class ApplicationServer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
        AccountService accountService = context.getBean(AccountService.class);
        List<Account> list = accountService.getAccount();
        log.info("账户大小：{}", list.size());
        for (Account account : list) {
            System.out.println(account.getCreateTime().toString("yyyy-MM-dd HH:mm:ss"));
        }

        log.info("更新用户");
        accountService.updateAccount(15L,"你好么");
    }
}
