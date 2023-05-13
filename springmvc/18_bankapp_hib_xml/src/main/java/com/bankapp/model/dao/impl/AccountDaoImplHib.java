package com.bankapp.model.dao.impl;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.entities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountDaoImplHib implements AccountDao {

    private SessionFactory sessionFactory;

    @Autowired
    public AccountDaoImplHib(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();//getCurrentSession? why not openSession()
    }
    @Override
    public List<Account> getAll() {
        return getSession().createQuery("select a from Account a", Account.class).list();
    }

    @Override
    public Account getById(int id) {
         return getSession().get(Account.class, id);
    }

    @Override
    public void updateAccount(Account account) {
        getSession().merge(account);
    }

    @Override
    public void addAccount(Account account) {
        getSession().persist(account);
    }

    @Override
    public void deleteAccount(int id) {
        Account accountToDelete= getById(id);
        if(accountToDelete!=null){
            getSession().remove(accountToDelete);
        }
    }
}
