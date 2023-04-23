package com.bankapp.model.dao.impl;

import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
@Primary
public class AccountDaoImplJdbc implements AccountDao {

    private DataSource datasource;

    @Autowired
    public AccountDaoImplJdbc(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<Account> getAll() {
        System.out.println("getAll using  jdbc...");
        //now i need to hit the data base
        Account account=null;
        List<Account> accounts=new ArrayList<>();
       try{
           Connection connection=datasource.getConnection();
           PreparedStatement pstmt=connection.prepareStatement("select * from acc_table");
            ResultSet rs= pstmt.executeQuery();
            while (rs.next()){
                account=new Account(rs.getInt(1),
                        rs.getString(3), rs.getBigDecimal(2));
                accounts.add(account);
            }
       }catch (SQLException ex){
           ex.printStackTrace();
       }
        return accounts;
    }

    @Override
    public Account getById(int id) {
        Account account=null;
        try{
            Connection connection=datasource.getConnection();
            PreparedStatement pstmt=connection.prepareStatement
                    ("select * from acc_table where id=?");
            pstmt.setInt(1,id);
            ResultSet rs= pstmt.executeQuery();
            while (rs.next()){
                account=new Account(rs.getInt(1),
                        rs.getString(3), rs.getBigDecimal(2));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        if(account==null)
            throw new BankAccountNotFoundException("account with id "+ id +" is not found");
        return account;
    }

    @Override
    public void updateAccount(Account account) {

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
