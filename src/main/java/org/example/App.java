package org.example;

import org.example.Util.HibernateUtil;
import org.example.dao.UserDao;
import org.example.entity.BankAccount;
import org.example.entity.User;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        User user = new User("kosmos", "11231", 4020);
        User user1 = new User("katya", "22221", 5224);
        BankAccount bankAccount = new BankAccount(1000,"кэшбэк 4 %", LocalDate.now());
        BankAccount bankAccount1 = new BankAccount(2000,"кэшбэк 3 %", LocalDate.now());
        UserDao userDao = new UserDao();
//
//        userDao.create(user, bankAccount);
//        userDao.create(user1, bankAccount1);


        User user2 = userDao.read(1);

        user2.setBankAccount(bankAccount);

        userDao.update(user2);
        System.out.println(user1);
        System.out.println(user2);
        BankAccount bankAccount2 = user2.getBankAccount();
        bankAccount2.setBalanceInRubles(5000);
        bankAccount2.setBonus("скидка 10 %");
        user2.setLogin("Masha");
        userDao.update(user2);


        HibernateUtil.closeSessionFactory();
    }
}
