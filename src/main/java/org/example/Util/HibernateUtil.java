package org.example.Util;

import org.example.entity.BankAccount;
import org.example.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(BankAccount.class)
                    .buildSessionFactory();
        }

        return sessionFactory;
    }
    public static void closeSessionFactory() {
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }
}

