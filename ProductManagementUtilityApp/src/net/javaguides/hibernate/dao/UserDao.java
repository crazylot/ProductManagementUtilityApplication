package net.javaguides.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;


import net.javaguides.hibernate.model.User;
import net.javaguides.hibernate.util.HiberateUtil;


public class UserDao {
	public boolean validate(String userName, String password) {

        Transaction transaction = null;
        User user = null;
        Session session=HiberateUtil.getsessionfactory().openSession();
        transaction = session.beginTransaction();
        user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName).uniqueResult();
        if (user != null && user.getPassword().equals(password)) {
        	return true;
        	} 
        transaction.commit();
        session.close();
        return false;
    }
}
