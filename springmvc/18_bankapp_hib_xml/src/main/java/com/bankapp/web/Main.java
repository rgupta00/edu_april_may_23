package com.bankapp.web;

//import com.bankapp.config.AppConfig;
import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ASSIGNMENT FOR STUDENTS
        //------------------CONVERT IT TO JAVA CONFIGURATIONS---------------

        ApplicationContext ctx = new ClassPathXmlApplicationContext("bank.xml");
        //ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        List<Account> accounts = accountService.getAll();
        accounts.forEach(a -> System.out.println(a));

        // Account account=accountService.getById(100);
//        System.out.println("---------------");
//        System.out.println(account);
        accountService.transfer(2, 3 ,new BigDecimal(10));
//
//        accounts=accountService.getAll();
//        accounts.forEach(a-> System.out.println(a));
//    }
    }
}
