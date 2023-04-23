package com.bankapp.model.dao.impl;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoImplJdbc implements AccountDao {

    private Map<Integer, Account> accounts=new HashMap<>();

    public AccountDaoImplJdbc() {
        accounts.put(1, new Account(1, "raj", new BigDecimal(1000)));
        accounts.put(2, new Account(2, "ekta", new BigDecimal(1000)));
    }


    @Override
    public List<Account> getAll() {
        System.out.println("getAll using  jdbc...");
        return new ArrayList<Account>(accounts.values());
    }

    @Override
    public Account getById(int id) {
        return accounts.get(id);
    }

    @Override
    public void updateAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public void addAccount(Account account) {
        //
    }

    @Override
    public void deleteAccount(int id) {
    //
    }
}
