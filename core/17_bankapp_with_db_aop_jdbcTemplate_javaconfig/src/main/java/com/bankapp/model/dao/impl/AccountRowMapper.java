package com.bankapp.model.dao.impl;

import com.bankapp.model.dao.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//callback method
public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account=new Account();
        account.setId(rs.getInt(1));
        account.setName(rs.getString(3));
        account.setBalance(rs.getBigDecimal(2));
        return account;
    }
}
