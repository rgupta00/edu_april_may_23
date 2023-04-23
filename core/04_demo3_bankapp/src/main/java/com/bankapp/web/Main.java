package com.bankapp.web;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("bankapp.xml");
        AccountService accountService= (AccountService) ctx.getBean("bankservice");
        List<Account> accounts=accountService.getAll();
        accounts.forEach(a-> System.out.println(a));

        accountService.transfer(1, 2 ,new BigDecimal(100));

        accounts=accountService.getAll();
        accounts.forEach(a-> System.out.println(a));
    }
}
