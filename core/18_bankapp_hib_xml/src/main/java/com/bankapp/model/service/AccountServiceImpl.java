package com.bankapp.model.service;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.entities.Account;
import com.bankapp.model.util.MyAppLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

//Brain of ur application: service layer : FR +NFR
//logging sec tx caching ... messing email support
@Service(value = "accountService")
@Transactional      //AOP: under the hood use Around advice
public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //Step 3: start using it
    @MyAppLogging
    @Override
    public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
        Account fromAcc=accountDao.getById(fromAccId);
        Account toAcc=accountDao.getById(toAccId);

        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
        toAcc.setBalance(toAcc.getBalance().add(amount));

        accountDao.updateAccount(fromAcc);

        accountDao.updateAccount(toAcc);
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
        Account account= accountDao.getById(id);
        if(account==null){
            throw new BankAccountNotFoundException("bank account with id "+ id +" is not found");
        }
        return account;
    }
}
