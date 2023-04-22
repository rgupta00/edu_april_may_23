package com.bankapp.model.service;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.impl.AccountDaoImplJdbc;
import com.bankapp.model.dao.impl.AccountDaoImplMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
//Brain of ur application: service layer : FR +NFR
//logging sec tx caching ... messing email support

public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
        Account fromAcc=accountDao.getById(fromAccId);
        Account toAcc=accountDao.getById(toAccId);

        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
        toAcc.setBalance(toAcc.getBalance().add(amount));

        accountDao.updateAccount(fromAcc);
        accountDao.updateAccount(toAcc);
        System.out.println("fund is transfered ....");//Using sysout is a bad thing : Log4j2
    }

    @Override
    public void deposit(int accId, BigDecimal amount) {
        Account acc=accountDao.getById(accId);
        acc.setBalance(acc.getBalance().add(amount));
        accountDao.updateAccount(acc);
    }

    @Override
    public void withdraw(int accId, BigDecimal amount) {
        Account acc=accountDao.getById(accId);
        acc.setBalance(acc.getBalance().subtract(amount));
        accountDao.updateAccount(acc);
    }

    @Override
    public List<Account> getAll() {
        return accountDao.getAll();
    }

    @Override
    public Account getById(int id) {
        return accountDao.getById(id);
    }
}
