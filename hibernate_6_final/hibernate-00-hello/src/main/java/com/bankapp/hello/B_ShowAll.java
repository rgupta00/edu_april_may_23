package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class B_ShowAll {
    public static void main(String[] args) {
       SessionFactory sf= SessionFactoryUtil.getSessionFactory();
       Session session=sf.openSession();

       //get all the records from the database          //HQL

        //ORM automatically map for pojo to db tables
        List<Account> accounts=session
                .createQuery("select a from Account a",Account.class)
                .list();

        accounts.forEach(a-> System.out.println(a));

        session.close();
        sf.close();

    }
}
















