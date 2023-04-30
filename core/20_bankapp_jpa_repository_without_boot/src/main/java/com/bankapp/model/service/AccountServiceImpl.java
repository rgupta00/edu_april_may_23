package com.bankapp.model.service;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.model.entities.Account;
import com.bankapp.model.repo.AccountRepo;
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

    private AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    //Step 3: start using it
    @MyAppLogging
    @Override
    public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
        Account fromAcc=accountRepo.getById(fromAccId);
        Account toAcc=accountRepo.getById(toAccId);

        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
        toAcc.setBalance(toAcc.getBalance().add(amount));

        accountRepo.save(fromAcc);
        accountRepo.save(toAcc);

    }

    @Override
    public void deposit(int accId, BigDecimal amount) {
        Account acc=accountRepo.getById(accId);
        acc.setBalance(acc.getBalance().add(amount));
        accountRepo.save(acc);
    }

    @Override
    public void withdraw(int accId, BigDecimal amount) {
        Account acc=accountRepo.getById(accId);
        acc.setBalance(acc.getBalance().subtract(amount));
        accountRepo.save(acc);
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }


    @Override
    public Account getById(int id) {
        Account account= accountRepo
                .findById(id)
                .orElseThrow(() -> new BankAccountNotFoundException("bank account not found !"+ id+" "));
        return account;
    }
}
