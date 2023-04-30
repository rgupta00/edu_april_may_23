package com.bankapp.hello;

import com.bankapp.factory.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class C_ShowById {
    public static void main(String[] args) {
       SessionFactory sf= SessionFactoryUtil.getSessionFactory();
       Session session=sf.openSession();

       Account account=session.get(Account.class, 3);   //get vs load

        System.out.println("-----------------------");
        System.out.println(account);

        session.close();
        sf.close();

    }
}
















