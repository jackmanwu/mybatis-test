package com.jackmanwu.springtest;

import com.jackmanwu.springtest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by JackManWu on 2019/7/5.
 */
@Slf4j
public class Server {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        log.info("当前用户名：{}", userService.getUsername(12));
    }
}
