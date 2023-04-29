package com.bankapp.model.dao.impl;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
@Primary
public class AccountDaoImplJdbcTemplate implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    //u need to tell spring how to map rs to a java object ie. RowMapper
    @Autowired
    public AccountDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> getAll() {
        return jdbcTemplate.query("select * from acc_table", new AccountRowMapper());
    }

    @Override
    public Account getById(int id) {
        return jdbcTemplate.queryForObject("select * from acc_table where id=?",
                new AccountRowMapper(), id);
    }

//    @Override
//    public Account getById(int id) {
//        return jdbcTemplate.queryForObject("select * from acc_table where id=?", ( rs,  rowNum)-> {
//                        Account account=new Account();
//                        account.setId(rs.getInt(1));
//                        account.setName(rs.getString(3));
//                        account.setBalance(rs.getBigDecimal(2));
//                        return account;
//
//                }, id);
//    }
    //jdbc.update : update/add/delete ;)
    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update acc_table set balance=? where id=?",
                new Object[] {account.getBalance(), account.getId()});
    }

    @Override
    public void addAccount(Account account) {
        jdbcTemplate.update("insert into acc_table(name, balance) values(?,?)",
                new Object[] {account.getName(), account.getBalance()});
    }

    @Override
    public void deleteAccount(int id) {
        jdbcTemplate.update("delete from acc_table where id=?", id);
    }
}
