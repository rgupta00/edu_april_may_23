package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class A_Insert {
    public static void main(String[] args) {


       SessionFactory sf= SessionFactoryUtil.getSessionFactory();


       Session session=sf.openSession();

        Transaction tx=session.getTransaction();

        try{
            tx.begin();
            Account account=new Account("ekta",new BigDecimal(1000));
            session.persist(account);
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
















