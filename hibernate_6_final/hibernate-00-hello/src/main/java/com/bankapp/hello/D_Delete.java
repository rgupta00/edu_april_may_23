package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class D_Delete {
    public static void main(String[] args) {
       SessionFactory sf= SessionFactoryUtil.getSessionFactory();
       Session session=sf.openSession();

        Transaction tx=session.getTransaction();

        try{
            tx.begin();

            //1. first find that account that u want to delete
            //2. remove if found

            Account account=session.get(Account.class, 1);
            session.remove(account);


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
















