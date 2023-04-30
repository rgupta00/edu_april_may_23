package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class C_Update {
    public static void main(String[] args) {


       SessionFactory sf= SessionFactoryUtil.getSessionFactory();


       Session session=sf.openSession();

        Transaction tx=session.getTransaction();

        try{
            tx.begin();

            //1. first find that account that u want to update
            //2. change the data and call update method

            Account account=session.get(Account.class, 3);
            account.setName("ravi");
            session.merge(account);


            tx.commit();
        }catch (HibernateException ex){
            ex.printStackTrace();
           try{
               tx.rollback();
           }catch (Exception e){
               e.printStackTrace();
           }
        }

        session.close();

        sf.close();

    }
}
















