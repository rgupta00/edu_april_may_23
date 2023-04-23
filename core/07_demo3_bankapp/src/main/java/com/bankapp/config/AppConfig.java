package com.bankapp.config;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.impl.AccountDaoImplMap;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.bankapp.*")
 public class AppConfig {
    //    @Bean vs @Component
    @Bean
    final public AccountDao getAccountDao(){
        return  new AccountDaoImplMap();
    }
    @Bean(name = "accountService")
    public AccountService getAccountService(AccountDao accountDao){
        AccountServiceImpl accountService=new AccountServiceImpl();
        accountService.setAccountDao(accountDao);
        return accountService;
    }
}
