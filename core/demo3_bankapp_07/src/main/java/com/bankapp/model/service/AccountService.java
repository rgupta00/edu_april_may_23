package com.bankapp.model.service;

import com.bankapp.model.dao.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public void transfer(int fromAccId, int toAccId, BigDecimal amount);

    public void deposit(int accId, BigDecimal amount);

    public void withdraw(int accId,  BigDecimal amount);

    public List<Account> getAll();

    public Account getById(int id);
}
